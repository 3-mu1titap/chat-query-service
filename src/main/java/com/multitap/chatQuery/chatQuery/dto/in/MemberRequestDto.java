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

}
