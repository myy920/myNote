package com.myy.dao;

import com.myy.domain.Person;

import java.util.List;

public interface PersonDao {

    int insert(String name, int age);

    int deleteById(long id);

    int updateById(long id, String name, int age);

    List<Person> selectAll();

}
