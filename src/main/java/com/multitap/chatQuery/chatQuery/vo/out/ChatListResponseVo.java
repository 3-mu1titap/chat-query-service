package com.multitap.chatQuery.chatQuery.vo.out;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.multitap.chatQuery.chatQuery.dto.in.ChatRequestDto;
import com.multitap.chatQuery.chatQuery.dto.in.MentoringRequestDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ChatListResponseVo {

    private String id;
    private ChatRequestDto chatRequestDto;
    private MentoringRequestDto mentoringRequestDto;
}
