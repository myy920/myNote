package com.myy.test;

import com.myy.domain.Person;
import com.myy.domain.Student;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FirstTest {

    /*依赖注入三种方式*/

    /**
     * 1.set注入
     */
    @Test
    public void test1(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        Object student = ac.getBean("student-createBySet");
        System.out.println((Student)student);
    }

    /**
     * 2.构造器注入
     */
    @Test
    public void test2(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        Object student = ac.getBean("student-createByConst");
        System.out.println((Student)student);
    }

    /**
     * 3.注解注入: @Component+@Value+@Autowired(@Resource)
     * @value注入简单类型
     * @Autowired:
     *      - 默认是ByType按同源类型注入,在@Autowired下加上@Qualifier("对象名称")则按照指定对象名称ByName注入:
     *           @Autowired
     *           @Qualifier("myschool")
     *      - required属性默认为true表示: 赋值错误就抛出异常;  required为false表示: 赋值错误继续运行,该对象为null;
     * @Resource: JDK中javax.annotation.Resource包中的类,默认按照@Resource("对象名称")的ByName注入,
     *      如果没有对象名称(@Resource)就按照首字母小写的对象注入;如果ByName找不到对象,则按照ByType查找
     */
    @Test
    public void test3(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("CreateBeanByComponent.xml");
        Object school = ac.getBean("school-createByComponent");
        System.out.println(school);
        Object student = ac.getBean("student-createByComponent");
        System.out.println((Student)student);
    }

    /**
     * autowire自动注入: autowire="byName"
     */
    @Test
    public void test4(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean-autowireByName.xml");
        Object student = ac.getBean("student-school");
        System.out.println((Student)student);
    }

    /**
     * autowire自动注入: autowire="byType"
     */
    @Test
    public void test5(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean-autowireByType.xml");
        Object student = ac.getBean("student-myschool");
        System.out.println((Student)student);
    }

    /**
     *
     */
}


















