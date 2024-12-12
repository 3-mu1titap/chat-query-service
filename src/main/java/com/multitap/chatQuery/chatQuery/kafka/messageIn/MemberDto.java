package com.multitap.chatQuery.chatQuery.kafka.messageIn;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@NoArgsConstructor
public class MemberDto {

    private String mentoringSessionUuid;
    private String memberUuid;

    @Builder
    public MemberDto(String mentoringSessionUuid, String memberUuid) {
        this.mentoringSessionUuid = mentoringSessionUuid;
        this.memberUuid = memberUuid;
    }
}
