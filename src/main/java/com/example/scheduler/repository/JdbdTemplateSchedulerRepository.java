package com.example.scheduler.repository;

import com.example.scheduler.dto.ScheduleResponseDto;
import com.example.scheduler.entity.Schedule;
import com.mysql.cj.result.Row;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

import javax.sql.DataSource;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class JdbdTemplateSchedulerRepository implements SchedulerRepository{

    private final JdbcTemplate jdbcTemplate;

    public JdbdTemplateSchedulerRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public ScheduleResponseDto addTodo(Schedule schedule) {

        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("schedule").usingGeneratedKeyColumns("id").usingColumns("todo","writer","password");

        //jdbcinsert -> usingColumns ->> 사용하는 컬럼들을 명시해서 , 사용하지 않는 컬럼은 default값 넣어줌,!!!!!!!!
        // created at, updated at 에 null이 들어가는 문제 해결!!

        Map<String,Object> parameters = new HashMap<>();
        parameters.put("todo",schedule.getTodo());
        parameters.put("writer",schedule.getWriter());
        parameters.put("password",schedule.getPassword());
//        parameters.put("created_at", LocalDateTime.now());
//        parameters.put("updated_at", LocalDateTime.now());


        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));


        //Schedule returnSchedule = jdbcTemplate.queryForObject("select * from schedule where id = ?", scheduleMapper(),key);

        List<Schedule> schedules = jdbcTemplate.query("select * from schedule where id = ?", scheduleMapper(), key);

        //jdbcTemplate queryForObject와 query의 차이점 알아내기
        //query를 실무에서 더 많이 씀 -> 이유 찾아서 til 작성

        Schedule returnSchedule = schedules.stream().findAny().orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "id가 존재하지 않습니다."));

        return new ScheduleResponseDto(key.longValue(), returnSchedule.getTodo(), returnSchedule.getWriter(), returnSchedule.getCreated_at(), returnSchedule.getUpdated_at());

    }

    @Override
    public List<ScheduleResponseDto> findAllSchedules(Date updatedAt, String writer) {

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("select * from schedule");

        List<Schedule> returnSchedules = jdbcTemplate.query("select * from schedule where updated_at = ? and writer = ?", scheduleMapper(), updatedAt, writer);

        //jdbcTemplate queryForObject와 query의 차이점 알아내기




        return List.of();
    }

    private RowMapper<Schedule> scheduleMapper() {
        return  new RowMapper<Schedule>() {
            @Override
            public Schedule mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Schedule(
                        rs.getLong("id"),
                        rs.getString("todo"),
                        rs.getString("writer"),
                        rs.getInt("password"),
                        rs.getDate("created_at"), //getDate하면 자동으로 '0000-00-00' 처리돼서 출력됨
                        rs.getDate("updated_at")
                );
            }
        };
    }
}
