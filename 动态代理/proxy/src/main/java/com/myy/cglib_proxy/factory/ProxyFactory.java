package com.myy.cglib_proxy.factory;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * cglib子类代理工厂
 * 对目标对象创建一个子类对象
 */
public class ProxyFactory implements MethodInterceptor {

    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    // 给目标创建一个代理对象
    public Object getProxy(){
        // 1.工具类
        Enhancer en = new Enhancer();
        // 2.设置父类
        en.setSuperclass(target.getClass());
        // 3.设置回调函数(指定MethodInterceptor对象)
        en.setCallback(this);
        // 4.创建子类(代理对象)
        return en.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println(method.getName());
        System.out.println("目标对象执行之前的扩展内容!");
        Object result = method.invoke(target, objects);
        System.out.println("目标对象执行之后的扩展内容!");
        return result;
    }
}
