package com.multitap.chatQuery.chatQuery.kafka;

import com.multitap.chatQuery.chatQuery.dto.in.ChatRequestDto;
import com.multitap.chatQuery.chatQuery.dto.in.MemberRequestDto;
import com.multitap.chatQuery.chatQuery.dto.in.MentoringRequestDto;

public interface KafkaConsumerService {
    void addChat(ChatRequestDto chatRequestDto, String uuid);
    void addMemberList(MemberRequestDto memberRequestDto, String mentoringSessionUuid);
}
