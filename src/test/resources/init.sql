drop table department if exists;
drop table user if exists;

create table department(
id int primary key IDENTITY,
name varchar(100),
remark varchar(100)
);

create table user(
id int primary key IDENTITY,
depid int,
name varchar(20),
pwd varchar(20),
createtime timestamp,
updatetime timestamp
);

insert into department(name, remark)
values('兵部', '行军打仗');
insert into department(name, remark)
values('工部', '营造');

insert into user(name, pwd, depid, createtime, updatetime)
values('抚远将军', '123456', 0, '2014-07-10 22:22:00', '2014-07-10 22:22:00');
insert into user(name, pwd, depid, createtime, updatetime)
values('参将', '123456', 0, '2014-07-10 22:26:00', '2014-07-10 22:26:00');
insert into user(name, pwd, depid, createtime, updatetime)
values('工部尚书', '123456', 1, '2014-07-10 22:26:00', '2014-07-10 22:26:00');
insert into user(name, pwd, depid, createtime, updatetime)
values('工部侍郎', '123456', 1, '2014-07-10 22:26:00', '2014-07-10 22:26:00');
