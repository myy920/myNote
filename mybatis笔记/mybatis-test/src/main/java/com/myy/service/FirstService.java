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
import java.util.List;


public class FirstService {

    /**
     * 1:
     * 由sqlSession执行sql语句
     * 要求: mapper.xml文件中的sql语句  +  sqlSession的对应sql的执行方法
     * @throws IOException
     */
    @Test
    public void test1() throws IOException {
        // 1.加载配置文件
        InputStream is = Resources.getResourceAsStream("mybatisConfig.xml");
        // 2.创建SqlSession工厂对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        // 3.创建sqlSession对象
        SqlSession sqlSession = factory.openSession();
        // 4.设置mapper.xml文件中的sql语句位置;   url = namespace + id
        String url = "com.myy.dao.PersonDao" +"."+"selectAll";
        // 5.由sqlSession对应的方法执行sql语句
        List<Person> list = sqlSession.selectList(url);
        list.forEach(person -> System.out.println(person));
        // 6.mybatis默认不自动提交: sqlSession.commit();
        // 7.释放资源
        sqlSession.close();
    }

    /**
     * 2:
     * sqlSession的getMapper方法
     * @throws IOException
     */
    @Test
    public void test2() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatisConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = factory.openSession();
        /**
         * sqlSession.getMapper方法通过接口使用JDK代理创建包含sql语句的代理对象,
         * 要求: mapper文件中的namespace必须和接口名称一样,id和对应方法名称一样
         */
        PersonDao proxy = sqlSession.getMapper(PersonDao.class);
        List<Person> list = proxy.selectAll();
        sqlSession.close();
    }

    /**
     * 3:
     * mybatis 和 spring 整合
     * spring容器中直接创建了接口的包含sql的JDK代理对象
     * 要求: 1.mapper.xml文件和接口同名;
     *      2.mapper.xml文件和接口在同一个包下, 或者在容器中指定了mapper.xml文件的位置
     */

}

















