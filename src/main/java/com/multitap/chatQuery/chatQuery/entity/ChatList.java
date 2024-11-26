package com.multitap.chatQuery.chatQuery.entity;

import com.multitap.chatQuery.chatQuery.dto.in.ChatRequestDto;
import com.multitap.chatQuery.chatQuery.dto.in.MentoringRequestDto;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@Builder
public class ChatList {

    @Id
    private String id;
    private ChatRequestDto chatInfo;
    private MentoringRequestDto mentoringInfo;
}
