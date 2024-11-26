package com.multitap.chatQuery.chatQuery.presentation;

import com.multitap.chatQuery.chatQuery.application.ChatListService;
import com.multitap.chatQuery.chatQuery.dto.out.ChatListResponseDto;
import com.multitap.chatQuery.chatQuery.feignClient.MentoringServiceFeignClient;
import com.multitap.chatQuery.chatQuery.vo.out.ChatListResponseVo;
import com.multitap.chatQuery.common.response.BaseResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/chatList")
public class ChatQueryController {

    private final ChatListService chatListService;
    private final MentoringServiceFeignClient mentoringServiceFeignClient;

    @GetMapping
    public BaseResponse<List<ChatListResponseVo>> getMemberInfo(@RequestHeader("userUuid") String uuid) {
        return new BaseResponse<>(chatListService.getChatList(uuid).stream()
                .map(ChatListResponseDto::toVo)
                .toList());
    }



}
