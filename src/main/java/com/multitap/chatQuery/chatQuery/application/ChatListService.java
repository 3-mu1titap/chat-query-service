package com.multitap.chatQuery.chatQuery.application;

import com.multitap.chatQuery.chatQuery.dto.out.ChatListResponseDto;

import java.util.List;

public interface ChatListService {
    List<ChatListResponseDto> getChatList(String uuid);
}
