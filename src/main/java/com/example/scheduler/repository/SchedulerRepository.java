package com.example.scheduler.repository;

import com.example.scheduler.dto.ScheduleRequestDto;
import com.example.scheduler.dto.ScheduleResponseDto;
import com.example.scheduler.entity.Schedule;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


public interface SchedulerRepository {


    ScheduleResponseDto addTodo(Schedule schedule);

    List<ScheduleResponseDto> findAllSchedules(LocalDate updatedAt, String writer);

    Schedule findSchedule(Long id);

    int editSchedule(Long id, ScheduleRequestDto dto);

    int deleteSchedule(Long id);
}
