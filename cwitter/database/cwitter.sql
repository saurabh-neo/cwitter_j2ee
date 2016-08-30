create database cwitter;
use cwitter;
create table user(name varchar(40),userid varchar(40) primary key,email varchar(60),password varchar(40));
create table messages(userid varchar(40),message varchar(200),time varchar(50));

insert into user(name,userid,email,password) values ("keanu","iamneo","whatisthematrix@gmail.com","keanu");
insert into user(name,userid,email,password) values ("user01","cooluser01","user01@yahoo.com","user01");
insert into user(name,userid,email,password) values ("user22","iamuser22","user22@gmail.com","user22");
insert into user(name,userid,email,password) values ("saurabh","saurabh_neo24","saurabhmatrixneo@gmail.com","saurabh");

insert into messages(userid,message,time)values("cooluser01","#dev testing cwitter","2016-08-26 05:02:24");
insert into messages(userid,message,time)values("iamneo","have a nice day #all","2016-08-27 12:02:14");
insert into messages(userid,message,time)values("iamuser22","Hey.. whats up @saurabh_neo24","2016-08-28 11:02:24");
insert into messages(userid,message,time)values("saurabh_neo24","#coding that's what I love","2016-08-29 11:02:24");

