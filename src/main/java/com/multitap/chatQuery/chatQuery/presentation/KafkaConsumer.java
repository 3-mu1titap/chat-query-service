package com.multitap.chatQuery.chatQuery.presentation;

import com.multitap.chatQuery.chatQuery.dto.in.ChatRequestDto;
import com.multitap.chatQuery.chatQuery.dto.in.MemberRequestDto;
import com.multitap.chatQuery.chatQuery.kafka.KafkaConsumerService;
import com.multitap.chatQuery.chatQuery.kafka.messageIn.ChatDto;
import com.multitap.chatQuery.chatQuery.kafka.messageIn.MemberDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Slf4j
@Component
public class KafkaConsumer {

    private final KafkaConsumerService kafkaConsumerService;

    @KafkaListener(topics = "create-chat-topic", groupId = "chat-consumer-group", containerFactory = "chatDtoListener")
    public void processChat(ChatDto chatDto) {
        log.info("Received chat request: {}", chatDto);
        kafkaConsumerService.addChat(ChatRequestDto.from(chatDto), chatDto.getMentoringSessionUuid());
    }

    @KafkaListener(topics = "chat-member-topic", groupId = "chat-consumer-group",containerFactory = "memberDtoListener" )
    public void processChatMember(MemberDto memberDto){
        log.info("Received chat request member: {}", memberDto);
        kafkaConsumerService.addMemberList(MemberRequestDto.from(memberDto),memberDto.getMentoringSessionUuid());
    }

}
