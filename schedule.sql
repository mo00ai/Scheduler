use scheduler;

drop table schedule;

create table schedule (
  id int not null auto_increment primary key,
  todo varchar(100) null,
  writer varchar(20) not null,
  password int not null,
  created_at timestamp default current_timestamp,
  updated_at timestamp default current_timestamp
);

SET explicit_defaults_for_timestamp=0;

#나중에 실행할 거
insert into schedule(id,todo,writer,password) values (null,'러닝','김철수',1234);

select * from schedule;



select * from schedule;



select id,todo, writer, password, date_format(created_at, '%Y-%m-%d') as created_at,date_format(updated_at, '%Y-%m-%d') as updated_at from schedule where id = 1;