package com.multitap.chatQuery.chatQuery.kafka;

import com.multitap.chatQuery.chatQuery.dto.in.ChatRequestDto;
import com.multitap.chatQuery.chatQuery.dto.in.MemberRequestDto;
import com.multitap.chatQuery.chatQuery.dto.in.MentoringRequestDto;
import com.multitap.chatQuery.chatQuery.entity.ChatList;
import com.multitap.chatQuery.chatQuery.feignClient.MentoringServiceFeignClient;
import com.multitap.chatQuery.chatQuery.feignClient.dto.SessionRoomResponseDto;
import com.multitap.chatQuery.chatQuery.infrastructure.ChatListRepository;
import com.multitap.chatQuery.common.exception.BaseException;
import com.multitap.chatQuery.common.response.BaseResponseStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.query.Criteria;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaConsumerServiceImpl implements KafkaConsumerService {

    private final ChatListRepository chatListRepository;
    private final MentoringServiceFeignClient mentoringServiceFeignClient;
    private final MongoTemplate mongoTemplate;

    @Override
    public void addChat(ChatRequestDto chatRequestDto, String mentoringSessionUuid) {

        // 1. mentoringSessionUuid로 기존 데이터 조회
        ChatList existingChat = chatListRepository.findById(mentoringSessionUuid)
                .orElseThrow(() -> new BaseException(BaseResponseStatus.NO_CHAT_LIST)); // 반드시 데이터가 존재한다고 가정

        // 2. 기존 데이터를 업데이트
        ChatList updatedChatList = ChatList.builder()
                .id(existingChat.getId()) // 기존 ID 유지
                .chatInfo(chatRequestDto) // 새로운 ChatInfo로 대체
                .mentoringInfo(existingChat.getMentoringInfo()) // 기존 MentoringInfo 유지
                .memberInfo(existingChat.getMemberInfo()) // 기존 MemberInfo 유지
                .build();

        // 3. 저장
        ChatList save = chatListRepository.save(updatedChatList);

        log.info("채팅 업데이트 성공: {}", save.getChatInfo().getMessage());
    }

    @Override
    public void addMemberList(MemberRequestDto memberRequestDto, String mentoringSessionUuid) {

        Query query = new Query(Criteria.where("_id").is(mentoringSessionUuid));

        Update update = new Update()
                .addToSet("memberInfo", memberRequestDto)
                .setOnInsert("mentoringInfo", MentoringRequestDto.from(
                        mentoringServiceFeignClient.findSessionRoomBySessionUuid(mentoringSessionUuid)));

        mongoTemplate.upsert(query, update, ChatList.class);
    }
}
