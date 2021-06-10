
drop database library;
create database library;

use library;

SET NAMES utf8;
START TRANSACTION;


create table users(
user_id Integer not null primary key AUTO_INCREMENT ,
user_name char(30) not null,
user_account char(30) not null,
user_password char(30) not null,
user_identity Integer default 0,
user_state Integer default 0,
user_remove Integer default 0
)ENGINE = INNODB DEFAULT CHARSET = utf8;

insert into users (user_name,user_account,user_password,user_identity) values ('罗成云','lcy123','123456',1);
insert into users (user_name,user_account,user_password,user_identity) values ('田梅','tm123','123456',1);
insert into users (user_name,user_account,user_password) values ('罗小云','lxy123','123456');
insert into users (user_name,user_account,user_password) values ('田小梅','txm123','123456');
insert into users (user_name,user_account,user_password) values ('罗罗','ll123','123456');
insert into users (user_name,user_account,user_password) values ('田田','tt123','123456');
insert into users (user_name,user_account,user_password) values ('小田田','xtt123','123456');
insert into users (user_name,user_account,user_password) values ('小罗罗','xll123','123456');




create table publishment(
publish_id Integer not null primary key AUTO_INCREMENT,
publish_name char(40) not null,
publish_local char(200) not null
)ENGINE = INNODB DEFAULT CHARSET = utf8;

insert into publishment (publish_name,publish_local) values ('人民教育出版社','北京市海淀区001公路002号');
insert into publishment (publish_name,publish_local) values ('西北工业大学出版社','陕西省西安市碑林区友谊路西工大');




create table author(
author_id Integer not null primary key AUTO_INCREMENT,
author_name char(30) not null,
author_sex Integer not null,
author_introduct char(200) 
)ENGINE = INNODB DEFAULT CHARSET = utf8;

insert into author(author_name,author_sex,author_introduct) values ('曹雪芹',1,'著名作家');
insert into author(author_name,author_sex,author_introduct) values ('吴承恩',0,'著名作家');


create table type(
type_id Integer not null primary key AUTO_INCREMENT,
type_name char(20) not null
)ENGINE = INNODB DEFAULT CHARSET = utf8;

insert into type (type_name) values ('文学');
insert into type (type_name) values ('名著');
insert into type (type_name) values ('历史');


create table book(
book_id Integer not null primary key AUTO_INCREMENT,
book_name char(60) not null ,
book_ISBN char(30) not null,
book_desc char(255) not null,
book_price double(10,2) not null,
book_release Date not null,
book_localtion char(40) not null,
book_state Integer not null,
book_author Integer not null,
book_publish Integer not null,
book_type Integer not null,
foreign key (book_author) references author(author_id),
foreign key (book_publish) references publishment(publish_id),
foreign key (book_type) references type(type_id)
)ENGINE = INNODB DEFAULT CHARSET = utf8;

insert into book(book_name,book_ISBN,book_desc,book_price,book_release,book_localtion,book_state,book_author,book_publish,book_type) 
values('红楼梦','11111111','四大名著之一',99.30,'1999-09-09','52-A-001',2,1,1,2);
insert into book(book_name,book_ISBN,book_desc,book_price,book_release,book_localtion,book_state,book_author,book_publish,book_type) 
values('西游记','22222222','四大名著之一',99.30,'1999-09-09','52-B-001',1,2,2,2);
insert into book(book_name,book_ISBN,book_desc,book_price,book_release,book_localtion,book_state,book_author,book_publish,book_type) 
values('红楼梦','11111111','四大名著之一',99.30,'1999-09-09','52-A-001',1,1,1,2);
insert into book(book_name,book_ISBN,book_desc,book_price,book_release,book_localtion,book_state,book_author,book_publish,book_type) 
values('西游记','22222222','四大名著之一',99.30,'1999-09-09','52-B-001',2,2,2,2);
insert into book(book_name,book_ISBN,book_desc,book_price,book_release,book_localtion,book_state,book_author,book_publish,book_type) 
values('红楼梦','11111111','四大名著之一',99.30,'1999-09-09','52-A-001',0,1,1,2);
insert into book(book_name,book_ISBN,book_desc,book_price,book_release,book_localtion,book_state,book_author,book_publish,book_type) 
values('西游记','22222222','四大名著之一',99.30,'1999-09-09','52-B-001',0,2,2,2);




create table lend(
lend_id Integer not null primary key AUTO_INCREMENT,
lend_book  Integer not null ,
lend_user Integer not null ,
lend_day Date not null,
lend_back Date ,
foreign key (lend_book) references book(book_id),
foreign key (lend_user) references users(user_id)
)ENGINE = INNODB DEFAULT CHARSET = utf8;

insert into lend (lend_book,lend_user,lend_day) values (1,3,'2020-02-20');
insert into lend (lend_book,lend_user,lend_day) values (4,4,'2020-02-20');
insert into lend (lend_book,lend_user,lend_day,lend_back) values (5,5,'2020-02-20','2020-04-20');

 

 
create table lendcar(
lendcar_id Integer not null primary key AUTO_INCREMENT,
lendcar_user Integer not null,
lendcar_book Integer not null,
foreign key (lendcar_book) references book(book_id),
foreign key (lendcar_user) references users(user_id)
)ENGINE = INNODB DEFAULT CHARSET = utf8;

insert into lendcar(lendcar_user,lendcar_book) values (3,6);
insert into lendcar(lendcar_user,lendcar_book) values (4,5);








