package com.multitap.chatQuery.chatQuery.application;

import com.multitap.chatQuery.chatQuery.dto.out.ChatListResponseDto;
import com.multitap.chatQuery.chatQuery.entity.ChatList;
import com.multitap.chatQuery.chatQuery.infrastructure.ChatListRepository;
import com.multitap.chatQuery.common.exception.BaseException;
import com.multitap.chatQuery.common.response.BaseResponseStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatListServiceImpl implements ChatListService {

    private final ChatListRepository chatListRepository;

    @Override
    public List<ChatListResponseDto> getChatList(String memberUuid) {
        List<ChatList> allByMemberUuidSorted = chatListRepository.findAllByChatMemberUuidSorted(memberUuid);

        if (allByMemberUuidSorted.isEmpty()) {
            throw new BaseException(BaseResponseStatus.NO_CHAT_LIST);
        }

        return allByMemberUuidSorted.stream()
                .map(ChatListResponseDto::from)
                .toList();

//        return ChatListResponseDto.from(allByMemberUuidSorted);
    }


}
