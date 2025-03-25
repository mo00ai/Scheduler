package com.example.scheduler.dto;

import lombok.Getter;

@Getter
public class ScheduleRequestDto {

    private String todo;
    private String writer;
    private int password;


//    public ScheduleRequestDto(String todo, String writer, int password) {
//        this.todo = todo;
//        this.writer = writer;
//        this.password = password;
//    }
}
