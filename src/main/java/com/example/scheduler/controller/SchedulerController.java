package com.example.scheduler.controller;

import com.example.scheduler.dto.ScheduleDeleteRequestDto;
import com.example.scheduler.dto.ScheduleRequestDto;
import com.example.scheduler.dto.ScheduleResponseDto;
import com.example.scheduler.service.SchedulerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/scheduler")
public class SchedulerController {

    private final SchedulerService schedulerService;

    public SchedulerController(SchedulerService schedulerService) {
        this.schedulerService = schedulerService;
    }

    @PostMapping
    public ResponseEntity<ScheduleResponseDto> addTodo(@RequestBody ScheduleRequestDto dto) {

        return new ResponseEntity<>(schedulerService.addTodo(dto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ScheduleResponseDto>> findAllSchedules(@RequestParam(required = false) LocalDate updated_at, @RequestParam(required = false) String writer) {

        return new ResponseEntity<>(schedulerService.findAllSchedules(updated_at, writer),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> findSchedule(@PathVariable Long id) {

        return new ResponseEntity<>(schedulerService.findSchedule(id),HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> editSchedule(@RequestBody ScheduleRequestDto requestDto, @PathVariable Long id) {

        return new ResponseEntity<>(schedulerService.editSchedule(id, requestDto) ,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable Long id, @RequestBody ScheduleDeleteRequestDto dto) {

        schedulerService.deleteSchedule(id,dto.getPassword());

        return new ResponseEntity<>(HttpStatus.OK);
    }


}
