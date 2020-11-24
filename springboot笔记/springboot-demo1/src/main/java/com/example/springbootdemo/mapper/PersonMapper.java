package com.example.springbootdemo.mapper;

import com.example.springbootdemo.entity.Person;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PersonMapper {

    @Insert("insert into tab_person(name, age, hobby) values(#{name}, #{age}, #{hobby})")
    int insert(String name, int age, String hobby);

    List<Person> selectAll();

    @Select("select count(1) from tab_person where name = #{name}")
    int selectByName(String name);
}
