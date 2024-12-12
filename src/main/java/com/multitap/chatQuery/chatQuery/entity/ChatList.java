package com.multitap.chatQuery.chatQuery.entity;

import com.multitap.chatQuery.chatQuery.dto.in.ChatRequestDto;
import com.multitap.chatQuery.chatQuery.dto.in.MemberRequestDto;
import com.multitap.chatQuery.chatQuery.dto.in.MentoringRequestDto;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Data
@Builder
public class ChatList {

    @Id
    private String id;
    private ChatRequestDto chatInfo;
    private MentoringRequestDto mentoringInfo;
    private List<MemberRequestDto> memberInfo;

}
