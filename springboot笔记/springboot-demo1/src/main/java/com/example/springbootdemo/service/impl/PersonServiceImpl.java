package com.example.springbootdemo.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.springbootdemo.entity.Person;
import com.example.springbootdemo.mapper.PersonMapper;
import com.example.springbootdemo.service.PersonService;
import com.github.pagehelper.PageHelper;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonMapper personMapper;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private StringRedisTemplate template;

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
        if (count == 0) {
            add = personMapper.insert(name, age, hobby);
        }
        return add;
    }

    /**
     * redis穿透
     *
     * @return
     */
    @Override
    public List<Person> selectAll() {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer(Object.class));
        List<Person> people = null;
        String peopleStr = redisTemplate.opsForValue().get("people", 0, -1);
        people = JSON.parseArray(peopleStr, Person.class);
        if (people == null) {
            people = personMapper.selectAll();
            if (people == null) {
                //防止穿透 设置redis中虚假key存活5s
                redisTemplate.opsForValue().set("people", null, 5, TimeUnit.SECONDS);
            } else {
                redisTemplate.opsForValue().set("people", people, 5, TimeUnit.MINUTES);
            }
        }
        return people;
    }

    public PersonServiceImpl() {
        super();
    }

    /**
     * mybatis RowBounds类分页： 适用于小规模数据
     *
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

    @Override
    public int add(Person person) {
        int i = personMapper.insertPerson(person);
        return i;
    }

    @Override
    public List<Person> selectByNameLike(String name) {
        List<Person> people = personMapper.selectByNameLike(name);
        return people;
    }

    @Override
    public Person selectById(long id) {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer(Object.class));

        Person person = (Person) redisTemplate.opsForValue().get("person" + id);
        if (person == null) {
            person = personMapper.selectById(id);
            redisTemplate.opsForValue().set("person" + id, person, 20, TimeUnit.SECONDS);
        }
        return person;
    }

    /**
     * 使用redis的setnx方法做排他锁
     */
    @Override
    public void redisTest() {
        Boolean lock = template.opsForValue().setIfAbsent("lock","");
        if (lock) {
            String ticket = template.opsForValue().get("ticket");
            System.out.println(Thread.currentThread().getName()+":"+ticket);
            int ticketNum = Integer.valueOf(ticket);
            ticketNum--;
            if (ticketNum <= 0) {
                template.opsForValue().set("ticket", "票已经卖完");
            } else {
                template.opsForValue().set("ticket", String.valueOf(ticketNum));
            }
            template.delete("lock");
        }
    }

}
