package com.multitap.chatQuery.chatQuery.dto.in;

import com.multitap.chatQuery.chatQuery.entity.ChatList;
import com.multitap.chatQuery.chatQuery.kafka.messageIn.MemberDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberRequestDto {

    private String chatMemberUuid;

    @Builder
    public MemberRequestDto(String chatMemberUuid) {
        this.chatMemberUuid = chatMemberUuid;
    }

    public static MemberRequestDto from(MemberDto memberDto) {
        return MemberRequestDto.builder()
                .chatMemberUuid(memberDto.getMemberUuid())
                .build();
    }

    public ChatList toEntity() {
        return ChatList.builder()

    }
}

//todo: 나도 이거 내꺼 보면서 해야 할 거 같은데 걍 지금 상태 커밋하고 내가 깃 클론 받아서 하면 안되나연?