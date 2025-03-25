package com.example.scheduler.service;

import com.example.scheduler.dto.ScheduleRequestDto;
import com.example.scheduler.dto.ScheduleResponseDto;

import java.sql.Date;
import java.util.List;

public interface SchedulerService {
    ScheduleResponseDto addTodo(ScheduleRequestDto dto);

    List<ScheduleResponseDto> findAllSchedules(Date updatedAt, String writer);
}
