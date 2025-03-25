package com.example.scheduler.entity;


import com.example.scheduler.dto.ScheduleRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@AllArgsConstructor
public class Schedule {

    private Long id;
    private String todo;
    private String writer;
    private int password;
    private LocalDate created_at; //local datetype
    private LocalDate updated_at;

    public Schedule(ScheduleRequestDto dto) {
        this.todo = dto.getTodo();
        this.writer = dto.getWriter();
        this.password = dto.getPassword();
    }
}
