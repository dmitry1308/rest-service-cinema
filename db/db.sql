drop database cinema;

create database cinema;

use cinema;

create table user
	(
		id int auto_increment,
		login varchar(20),
    password varchar(20),

    primary key(id)
	)
    default char set cp1251;

insert into user (login,password) value
	('dima','1111'),
	('ivan','2222');