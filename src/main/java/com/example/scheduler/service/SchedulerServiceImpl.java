package com.example.scheduler.service;

import com.example.scheduler.dto.ScheduleRequestDto;
import com.example.scheduler.dto.ScheduleResponseDto;
import com.example.scheduler.entity.Schedule;
import com.example.scheduler.repository.SchedulerRepository;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class SchedulerServiceImpl implements SchedulerService {

    private final SchedulerRepository schedulerRepository;

    public SchedulerServiceImpl(SchedulerRepository schedulerRepository) {
        this.schedulerRepository = schedulerRepository;
    }


    @Override
    public ScheduleResponseDto addTodo(ScheduleRequestDto dto) {

        Schedule schedule = new Schedule(dto);

        return schedulerRepository.addTodo(schedule);
    }

    @Override
    public List<ScheduleResponseDto> findAllSchedules(Date updatedAt, String writer) {
        return schedulerRepository.findAllSchedules(updatedAt, writer);
    }
}
