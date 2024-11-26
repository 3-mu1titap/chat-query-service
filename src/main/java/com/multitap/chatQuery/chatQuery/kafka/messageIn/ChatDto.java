package com.multitap.chatQuery.chatQuery.kafka.messageIn;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@ToString
@Getter
@NoArgsConstructor
public class ChatDto {

    private String mentoringSessionUuid;
    private String memberUuid;
    private LocalDateTime lastMessageTime;
    private String lastMessage;


    @Builder
    public ChatDto(String memberUuid, String mentoringSessionUuid, LocalDateTime lastMessageTime,  String lastMessage) {
        this.memberUuid = memberUuid;
        this.mentoringSessionUuid = mentoringSessionUuid;
        this.lastMessageTime = lastMessageTime;
        this.lastMessage = lastMessage;
    }
}
