create database db_springboot_test;

use db_springboot_test;

create table tab_person(
    id int primary key auto_increment,
    name varchar(32),
    age int(5),
    hobby varchar(64)
)