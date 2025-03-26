package com.example.scheduler.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
public class ScheduleRequestDto {

    @Setter
    private String todo;
    @Setter
    private String writer;
    private Integer password;

}
