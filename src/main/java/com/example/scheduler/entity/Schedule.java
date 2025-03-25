package com.example.scheduler.entity;


import com.example.scheduler.dto.ScheduleRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class Schedule {

    private Long id;
    private String todo;
    private String writer;
    private int password;
    private Date created_at; //local datetype
    private Date updated_at;

    public Schedule(ScheduleRequestDto dto) {
        this.todo = dto.getTodo();
        this.writer = dto.getWriter();
        this.password = dto.getPassword();
    }
}
