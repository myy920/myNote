package com.example.springbootdemo.service.impl;

import com.example.springbootdemo.entity.Person;
import com.example.springbootdemo.mapper.PersonMapper;
import com.example.springbootdemo.service.PersonService;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonMapper personMapper;

    @Override
    @Transactional(
            propagation = Propagation.REQUIRED,
            isolation = Isolation.DEFAULT,
            rollbackFor = {SQLException.class}
    )
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

    public PersonServiceImpl() {
        super();
    }

    /**
     * mybatis RowBounds类分页： 适用于小规模数据
     * @param rowBounds
     * @return
     */
    @Override
    public List<Person> selectAllAndPage(RowBounds rowBounds) {
        List<Person> people = personMapper.selectAllAndPage(rowBounds);
        return people;
    }

    @Override
    public List<Person> selectAllAndPageHelper(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Person> people = personMapper.selectAll();
        return people;
    }

}
