# 创建测试的数据库
create database db_mybatis_test;
# 使用数据库
use db_mybatis_test;
# 创建表
create table tab_person(
    id int(11) primary key auto_increment,
    name varchar(50) unique,
    age int(5) not null
);
# 添加数据
insert into tab_person(name,age) values('张三',18),
                                        ('李四',19),
                                        ('王五',18);
# 查询
select * from tab_person;