package com.example.springbootdemo.service;

import com.example.springbootdemo.entity.Person;

import java.util.List;

public interface PersonService {

    int add(String name, int age, String hobby);

    List<Person> selectAll();
}
