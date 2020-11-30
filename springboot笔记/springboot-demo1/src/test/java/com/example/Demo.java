package com.example;

import com.alibaba.fastjson.JSON;
import com.example.springbootdemo.entity.Person;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Demo {
    @Test
    public void test1(){

        List<Person> personList = JSON.parseArray(null, Person.class);
        if (personList == null){
            System.out.println(1);
        }

    }
}
