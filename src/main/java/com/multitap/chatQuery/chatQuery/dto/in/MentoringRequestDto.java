package com.multitap.chatQuery.chatQuery.dto.in;

import com.multitap.chatQuery.chatQuery.entity.ChatList;
import com.multitap.chatQuery.chatQuery.feignClient.dto.MentoringDto;
import com.multitap.chatQuery.chatQuery.feignClient.dto.SessionRoomResponseDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@NoArgsConstructor
public class MentoringRequestDto {

    private String mentoringUuid;
    private String mentoringName;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalTime startTime;
    private LocalTime endTime;

    @Builder
    public MentoringRequestDto(String mentoringUuid, String mentoringName, LocalDate startDate, LocalDate endDate, LocalTime startTime, LocalTime endTime) {
        this.mentoringUuid = mentoringUuid;
        this.mentoringName = mentoringName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public static MentoringRequestDto from(SessionRoomResponseDto sessionRoomResponseDto) {
        return MentoringRequestDto.builder()
                .mentoringUuid(sessionRoomResponseDto.getMentoringUuid())
                .mentoringName(sessionRoomResponseDto.getMentoringName())
                .startDate(sessionRoomResponseDto.getStartDate())
                .endDate(sessionRoomResponseDto.getEndDate())
                .startTime(sessionRoomResponseDto.getStartTime())
                .endTime(sessionRoomResponseDto.getEndTime())
                .build();
    }

    public ChatList toEntity(MentoringRequestDto mentoringRequestDto, ChatList chatList) {
        return ChatList.builder()
                .id(chatList.getId())
                .chatInfo(chatList.getChatInfo())
                .mentoringInfo(mentoringRequestDto)
                .build();
    }
}
