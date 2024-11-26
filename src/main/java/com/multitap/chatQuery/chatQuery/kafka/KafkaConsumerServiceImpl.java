package com.multitap.chatQuery.chatQuery.kafka;

import com.multitap.chatQuery.chatQuery.dto.in.ChatRequestDto;
import com.multitap.chatQuery.chatQuery.dto.in.MentoringRequestDto;
import com.multitap.chatQuery.chatQuery.entity.ChatList;
import com.multitap.chatQuery.chatQuery.feignClient.MentoringServiceFeignClient;
import com.multitap.chatQuery.chatQuery.feignClient.dto.SessionRoomResponseDto;
import com.multitap.chatQuery.chatQuery.infrastructure.ChatListRepository;
import com.multitap.chatQuery.common.exception.BaseException;
import com.multitap.chatQuery.common.response.BaseResponseStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaConsumerServiceImpl implements KafkaConsumerService {

    private final ChatListRepository chatListRepository;
    private final MentoringServiceFeignClient mentoringServiceFeignClient;

    @Override
    public void addChat(ChatRequestDto chatRequestDto, String mentoringSessionUuid) {

        // 1. mentoringSessionUuid로 기존 데이터 조회
        Optional<ChatList> existingChat = chatListRepository.findById(mentoringSessionUuid);

        // 2. 새 엔티티 생성 (기존 데이터가 있으면 ID 유지)
        ChatList chatList = existingChat
                .map(chat -> ChatList.builder()
                        .id(chat.getId()) // 기존 ID 유지
                        .chatInfo(chatRequestDto) // 새로운 ChatInfo로 대체
                        .mentoringInfo(chat.getMentoringInfo()) // 필요시 기존 데이터 유지
                        .build())
                .orElseGet(() -> {
                    MentoringRequestDto mentoringRequestDto = MentoringRequestDto.from(mentoringServiceFeignClient.getSessionRoom(mentoringSessionUuid));
                    log.info("{}", mentoringRequestDto);
                    return chatRequestDto.toEntity(chatRequestDto, mentoringRequestDto, mentoringSessionUuid); // 없으면 새로 생성
                        });

        // 3. 저장 (기존 ID면 업데이트, 없으면 새로 저장)
        chatListRepository.save(chatList);
        log.info("{} 채팅 성공: {}", existingChat.isPresent() ? "채팅 업데이트" : "채팅 저장", chatRequestDto.getMessage());
    }

}
