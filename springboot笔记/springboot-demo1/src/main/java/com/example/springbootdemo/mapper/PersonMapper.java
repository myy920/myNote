package com.example.springbootdemo.mapper;

import com.example.springbootdemo.entity.Person;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.RowBounds;

import java.util.List;


public interface PersonMapper {

    @Insert("insert into tab_person(name, age, hobby) values(#{name}, #{age}, #{hobby})")
    int insert(String name, int age, String hobby);

    int insertPerson(Person person);

    List<Person> selectAll();

    List<Person> selectAllAndPage(RowBounds rowBounds);

    @Select("select * from tab_person")
    List<Person> selectAllAndPageHelper(int pageNum, int pageSize);

    @Select("select count(1) from tab_person where name = #{name}")
    int selectByName(String name);

    @Select("select * from tab_person where name like concat('%',#{name},'%')")
    List<Person> selectByNameLike(String name);



}
