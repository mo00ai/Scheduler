package com.example.scheduler.service;

import com.example.scheduler.dto.ScheduleRequestDto;
import com.example.scheduler.dto.ScheduleResponseDto;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;
import java.util.List;

public interface SchedulerService {
    ScheduleResponseDto addTodo(ScheduleRequestDto dto);

    List<ScheduleResponseDto> findAllSchedules(LocalDate updatedAt, String writer);

    ScheduleResponseDto findSchedule(Long id);

    ScheduleResponseDto editSchedule(Long id, ScheduleRequestDto dto);

    void deleteSchedule(Long id, int password);
}
