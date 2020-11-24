package com.example.springbootdemo.service.impl;

import com.example.springbootdemo.entity.Person;
import com.example.springbootdemo.mapper.PersonMapper;
import com.example.springbootdemo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonMapper personMapper;

    @Override
    @Transactional
    public int add(String name, int age, String hobby) {
        //添加前先查询name是否已经存在
        int count = personMapper.selectByName(name);
        int add = 0;
        if (count == 0){
            add = personMapper.insert(name, age, hobby);
        }
        return add;
    }

    @Override
    public List<Person> selectAll() {
        List<Person> list = personMapper.selectAll();
        return list;
    }
}
