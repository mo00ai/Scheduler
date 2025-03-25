package com.example.scheduler.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class ScheduleResponseDto {

    private Long id;
    private String todo;
    private String writer;
    private Date created_at;
    private Date updated_at;

}
