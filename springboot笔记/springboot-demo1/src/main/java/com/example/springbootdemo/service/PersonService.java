package com.example.springbootdemo.service;

import com.example.springbootdemo.entity.Person;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface PersonService {

    int add(String name, int age, String hobby);

    int add(Person person);

    List<Person> selectAll();

    List<Person> selectAllAndPage(RowBounds rowBounds);

    List<Person> selectAllAndPageHelper(int pageNum, int pageSize);

    List<Person> selectByNameLike(String name);

    Person selectById(long id);

    public void redisTest();
}
