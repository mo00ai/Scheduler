package com.example.scheduler.service;

import com.example.scheduler.dto.ScheduleRequestDto;
import com.example.scheduler.dto.ScheduleResponseDto;
import com.example.scheduler.entity.Schedule;
import com.example.scheduler.repository.SchedulerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;

@Service
public class SchedulerServiceImpl implements SchedulerService {

    private final SchedulerRepository schedulerRepository;

    public SchedulerServiceImpl(SchedulerRepository schedulerRepository) {
        this.schedulerRepository = schedulerRepository;
    }


    @Transactional
    @Override
    public ScheduleResponseDto addTodo(ScheduleRequestDto dto) {

        //필수값들 입력 안했는지 검사
        if(dto.getWriter() == null || dto.getPassword() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"필수값인 작성자와 비밀번호를 반드시 입력해주세요.");
        }

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

    @Transactional
    @Override
    public ScheduleResponseDto editSchedule(Long id, ScheduleRequestDto dto) {

        Schedule originalSchedule = schedulerRepository.findSchedule(id);

        //dto 입력안해서 null 일 때, 수정 전 데이터를 default로 해주고싶음 이렇게 하지만
        //애초에 dto 자체의 default 정해주고 싶으면 빈생성자 dto()의 this.parameter = 0; 의 값을 정해줌 
        //데이터의 default는 db 테이블에서
        if(dto.getTodo() == null) {
            dto.setTodo(originalSchedule.getTodo());
        } else if(dto.getWriter() == null) {
            dto.setWriter(originalSchedule.getWriter());
        }


        int updatedRow = schedulerRepository.editSchedule(id, dto);

        if(updatedRow == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + id);
        }

        Schedule editedSchedule = schedulerRepository.findSchedule(id);

        return new ScheduleResponseDto(editedSchedule);
    }

    @Override
    public void deleteSchedule(Long id,Integer password) {
        int deletedRow = schedulerRepository.deleteSchedule(id,password);

        if(deletedRow == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "id가 존재하지 않습니다."+id);
        }

    }
}
