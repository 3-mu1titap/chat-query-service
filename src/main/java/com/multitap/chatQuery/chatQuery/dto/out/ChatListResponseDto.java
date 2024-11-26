package com.multitap.chatQuery.chatQuery.dto.out;

import com.multitap.chatQuery.chatQuery.dto.in.ChatRequestDto;
import com.multitap.chatQuery.chatQuery.dto.in.MentoringRequestDto;
import com.multitap.chatQuery.chatQuery.entity.ChatList;
import com.multitap.chatQuery.chatQuery.vo.out.ChatListResponseVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ChatListResponseDto {

    private String id;
    private ChatRequestDto chatRequestDto;
    private MentoringRequestDto mentoringRequestDto;

    @Builder
    public ChatListResponseDto(String id, ChatRequestDto chatRequestDto, MentoringRequestDto mentoringRequestDto) {
        this.id = id;
        this.chatRequestDto = chatRequestDto;
        this.mentoringRequestDto = mentoringRequestDto;
    }

    public static ChatListResponseDto from(ChatList chatList) {
        return ChatListResponseDto.builder()
                .id(chatList.getId())
                .chatRequestDto(chatList.getChatInfo())
                .mentoringRequestDto(chatList.getMentoringInfo())
                .build();
    }

    public ChatListResponseVo toVo() {
        return ChatListResponseVo.builder()
                .id(id)
                .chatRequestDto(chatRequestDto)
                .mentoringRequestDto(mentoringRequestDto)
                .build();
    }
}
