package com.multitap.chatQuery.chatQuery.feignClient.dto;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class SessionRoomResponseDto {

    private String mentoringUuid;
    private String mentoringName;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalTime startTime;
    private LocalTime endTime;

//    @Builder
//    public SessionRoomResponseDto(String mentoringUuid, String mentoringName, LocalDate startDate, LocalDate endDate, LocalTime startTime, LocalTime endTime) {
//        this.mentoringUuid = mentoringUuid;
//        this.mentoringName = mentoringName;
//        this.startDate = startDate;
//        this.endDate = endDate;
//        this.startTime = startTime;
//        this.endTime = endTime;
//    }
}
