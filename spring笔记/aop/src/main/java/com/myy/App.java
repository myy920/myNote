package com.myy;

import com.myy.service.Service1;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App {

    /**
     * Aspect Oriented Programming(面向切面编程) 是动态代理的规范化,把动态代理的实现方式都定义好,使用JDK动态代理和CGLIB动态代理.
     * AOP的术语:
     *      1.aspect: 切面即功能代码
     *      2.连接点JoinPoint: 目标类中的具体方法
     *      3.切入点:Pointcut: 多个连接点
     *      4.目标对象: 给哪个类的方法增加功能,这个类就是目标对象
     *      5.Advice通知: 通知表达切面执行时间
     * AOP执行三要素:
     *      1.aspect: 功能代码
     *      2.切面添加位置(连接点或者切入点)
     *      3.切面执行时间(Advice)
     * spring内部实现了AOP,但其AOP比较笨重,所以通过添加aspectj的依赖,使用aspectj的注解或xml配置
     * aspectj的通知:
     *      1. @Before
     *      2. @AfterReturning
     *      3. @Around
     *      4. @AfterThrowing
     *      5. @After
     *
     *
     */

    /**
     * 执行流程:
     * @Around开始-->[ @Before-->@AfterReturning-->@After ]相当于pjp.proceed() -->@Around结束
     */
    @Test
    public void test1(){
        Service1 s1 = new Service1();
        int i = s1.doSome1(123);
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext-aspect.xml");
        Object obj = ac.getBean("service1");
        if (obj instanceof Service1){
            Service1 service1 = (Service1)obj;
            int result = service1.doSome1(123);
            System.out.println(result);
        }
    }
}

















