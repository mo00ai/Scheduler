package com.example.scheduler.repository;

import com.example.scheduler.dto.ScheduleResponseDto;
import com.example.scheduler.entity.Schedule;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;


public interface SchedulerRepository {


    ScheduleResponseDto addTodo(Schedule schedule);

    List<ScheduleResponseDto> findAllSchedules(Date updatedAt, String writer);
}
