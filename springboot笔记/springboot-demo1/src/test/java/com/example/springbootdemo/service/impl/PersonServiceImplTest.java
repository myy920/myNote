package com.example.springbootdemo.service.impl;

import com.example.springbootdemo.entity.Person;
import com.example.springbootdemo.service.PersonService;
import org.apache.ibatis.session.RowBounds;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.List;


@SpringBootTest
class PersonServiceImplTest {

    @Autowired
    private PersonService personService;

    @Test
    void add() {
        int add = personService.add("柳柳", 13, "跑步");
        System.out.println(add);

    }

    @Test
    void selectAll() {
        List<Person> people = personService.selectAll();
        //List<Person> newPeople = people.subList(1, 3);
        people.forEach(person -> System.out.println(person));
    }


    @Test
    void selectAllAndPage() {
        List<Person> people = personService.selectAllAndPage(new RowBounds(3, 5));
        people.forEach(person -> System.out.println(person));
    }

    @Test
    void selectAllAndPageHelper() {
        List<Person> people = personService.selectAllAndPageHelper(2, 5);
        people.forEach(person -> System.out.println(person));
    }

    @Test
    void add1() {
        Person person = new Person();
        person.setName("官燕");
        person.setAge(15);
        person.setHobby("打架");
        int add = personService.add(person);
        System.out.println(person);
    }

    @Test
    void selectByNameLike() {
        List<Person> people = personService.selectByNameLike("燕");
        people.forEach(person -> System.out.println(person));
    }
    @Test
    void selectById(){
        Person person = personService.selectById(13);
        System.out.println(person);
    }
}