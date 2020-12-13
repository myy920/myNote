package com.myy.service;


import com.myy.dao.PersonDao;
import com.myy.domain.Person;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * mybatis传参
 *
 */
public class SecondService {

    /**
     * 传入参数:
     *      1.默认按照方法中的参数名传入
     *      2.自定义参数名称传入: @Param
     *      3.对象传入
     */

    /**
     * 传出参数:
     *      1.resultType
     *      2.resultMap
     *
     *
     */


    /**
     * 接口参数为集合的动态sql测试
     */
    @Test
    public void test1() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatisConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = factory.openSession();
        PersonDao mapper = sqlSession.getMapper(PersonDao.class);

        List<Person> list = new ArrayList<>();
        list.add(new Person(100,"张大炮",18));
        list.add(new Person(101,"李大嘴",28));
        list.add(new Person(102,"李莉",18));
        list.add(new Person(103,"张明",19));

        int i = mapper.insertSome(list);
        System.out.println(i);
        sqlSession.commit();

        sqlSession.close();
    }




}











