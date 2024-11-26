package com.multitap.chatQuery.chatQuery.dto.in;

import com.multitap.chatQuery.chatQuery.entity.ChatList;
import com.multitap.chatQuery.chatQuery.kafka.messageIn.ChatDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class ChatRequestDto {

    private String memberUuid;
    private String message;
    private LocalDateTime sentAt;

    @Builder
    public ChatRequestDto(String memberUuid, String message, LocalDateTime sentAt) {
        this.memberUuid = memberUuid;
        this.message = message;
        this.sentAt = sentAt;
    }

    public static ChatRequestDto from(ChatDto chatDto) {
        return ChatRequestDto.builder()
                .memberUuid(chatDto.getMemberUuid())
                .message(chatDto.getLastMessage())
                .sentAt(chatDto.getLastMessageTime())
                .build();
    }

    public ChatList toEntity(ChatRequestDto chatRequestDto, MentoringRequestDto mentoringRequestDto, String mentoringSessionUuid) {
        return ChatList.builder()
                .id(mentoringSessionUuid)
                .chatInfo(chatRequestDto)
                .mentoringInfo(mentoringRequestDto)
                .build();
    }

}
