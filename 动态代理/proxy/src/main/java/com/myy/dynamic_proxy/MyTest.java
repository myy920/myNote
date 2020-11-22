package com.myy.dynamic_proxy;

import com.myy.dynamic_proxy.Handler.BHandler;
import com.myy.dynamic_proxy.entity.BImpl1;
import com.myy.dynamic_proxy.entity.BImpl2;
import com.myy.dynamic_proxy.interfaces.B;
import org.junit.jupiter.api.Test;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理: 也称JDK代理,接口代理
 *      优点: 利用JDK的API生成代理对象,动态地在内存中创建代理对象,无需代理类; 当更新接口中的方法时,只需要维护实现类.
 *
 *      个人观点:
 *      JDK代理生成的代理类重写了其祖类的的所有方法(包括Object的toString,hashCode等方法),
 *      并且每个方法中都调用了InvocationHandler的invoke方法,
 *      invoke中的参数就是在其创建时添加到其中
 */
public class MyTest {

    /**
     * 1.直接使用JDK的动态代理
     */
       @Test
    public void test1(){
        B b = (B)Proxy.newProxyInstance(BImpl1.class.getClassLoader(), BImpl1.class.getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("执行扩展内容!");
                Object result = method.invoke(new BImpl1(),args);
                return result;
            }
        });
        b.method1(1230);
        b.method2("abc");
    }

    /**
     * 2.对invocationHandler进行封装
     */
    @Test
    public void test2() throws InterruptedException {
        BImpl1 b1 = new BImpl1();
        BHandler bHandler = new BHandler(b1);
        B b = (B)Proxy.newProxyInstance(BImpl1.class.getClassLoader(), BImpl1.class.getInterfaces(),bHandler);
        b.method1(4567);
        b.method2("ssssa");
    }
}

























