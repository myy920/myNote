package com.myy.dynamic_proxy.Handler;

import com.myy.dynamic_proxy.interfaces.B;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class BHandler implements InvocationHandler {

    // 获取目标类对象
    private Object obj;

    public BHandler(Object obj) {
        this.obj = obj;
    }

    // 扩展的方法
    private void puls(){
        System.out.println("执行扩展内容!");
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        puls();
        Object result = method.invoke(obj,args);
        return result;
    }
}
