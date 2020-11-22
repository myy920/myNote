package com.myy.cglib_proxy;

import com.myy.cglib_proxy.entity.C;
import com.myy.cglib_proxy.factory.ProxyFactory;
import org.junit.jupiter.api.Test;

/**
 * cglib的动态代理原理是继承
 *
 * 在spring的AOP编程中,如果加入容器的目标对象有实现接口,就用JDK代理;如果目标对象没有实现接口,就用cglib代理
 *
 */
public class MyTest {
    @Test
    public void test1(){
        C c = new C();
        ProxyFactory factory = new ProxyFactory(c);
        Object proxy = factory.getProxy();
        if (proxy instanceof C){
            C cProxy = (C)proxy;
            int i = cProxy.method1(789);
        }
    }

}
