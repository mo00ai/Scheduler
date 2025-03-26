use scheduler;


create table schedule (
  id int not null auto_increment primary key,
  todo varchar(100) null,
  writer varchar(20) not null,
  password int not null,
  created_at timestamp default current_timestamp,
  updated_at timestamp default current_timestamp on update current_timestamp
);



create table schedule (
  id int not null auto_increment primary key,
  todo varchar(100) null,
  password int not null,
  created_at timestamp default current_timestamp,
  updated_at timestamp default current_timestamp on update current_timestamp
);

create table user (
  id int not null auto_increment primary key,
  name varchar(20) not null,
  email varchar(30)
);


drop table schedule;
drop table user;


select * from schedule;





