package com.example.scheduler.service;

import com.example.scheduler.dto.ScheduleRequestDto;
import com.example.scheduler.dto.ScheduleResponseDto;
import com.example.scheduler.entity.Schedule;
import com.example.scheduler.repository.SchedulerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
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
    public List<ScheduleResponseDto> findAllSchedules(LocalDate updated_at, String writer) {
        return schedulerRepository.findAllSchedules(updated_at, writer);
    }

    @Override
    public ScheduleResponseDto findSchedule(Long id) {
        return new ScheduleResponseDto(schedulerRepository.findSchedule(id));
    }

    @Override
    public ScheduleResponseDto editSchedule(Long id, ScheduleRequestDto dto) {

        Schedule originalSchedule = schedulerRepository.findSchedule(id);

        if(dto.getTodo() == null) {
            dto.setTodo(originalSchedule.getTodo());
        } else if(dto.getWriter() == null) {
            dto.setWriter(originalSchedule.getWriter());
        }



//        if(dto.getTodo() == null || dto.getWriter() == null) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The title and contents are required values.");
//        }

        int updatedRow = schedulerRepository.editSchedule(id, dto);

        if(updatedRow == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + id);
        }

        Schedule editedSchedule = schedulerRepository.findSchedule(id);

        return new ScheduleResponseDto(editedSchedule);
    }
}
