package com.example.springbootdemo.service.impl;

import com.example.springbootdemo.entity.Person;
import com.example.springbootdemo.service.PersonService;
import org.apache.ibatis.session.RowBounds;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@SpringBootTest
class PersonServiceImplTest {

    @Autowired
    private PersonService personService;

    @Test
    void add() {

    }

    @Test
    void selectAll() {
        List<Person> people = personService.selectAll();
        List<Person> newPeople = people.subList(1, 3);
        newPeople.forEach(person -> System.out.println(person));
    }

    @Test
    void selectAllAndPage() {
        List<Person> people = personService.selectAllAndPage(new RowBounds(3, 5));
        people.forEach(person -> System.out.println(person));
    }

    @Test
    void selectAllAndPageHelper() {
        List<Person> people = personService.selectAllAndPageHelper(1, 5);
        people.forEach(person -> System.out.println(person));
    }
}