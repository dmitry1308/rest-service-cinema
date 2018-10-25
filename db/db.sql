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

create table cinema1_hall1
	(
		id int auto_increment primary key,
        row int,
        place1 varchar(10),
        place2 varchar(10),
		place3 varchar(10)
	)
	  default char set cp1251;

insert into cinema1_hall1 (row,place1,place2,place3) values
 (1,'free','free','free'),
 (2,'free','free','free'),
 (3,'free','free','free');