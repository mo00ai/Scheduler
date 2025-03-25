package com.example.scheduler.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
public class ScheduleRequestDto {

    @Setter
    private String todo;
    @Setter
    private String writer;
    private int password;



//    public ScheduleRequestDto(String todo, String writer, int password) {
//        this.todo = todo;
//        this.writer = writer;
//        this.password = password;
//    }
}
