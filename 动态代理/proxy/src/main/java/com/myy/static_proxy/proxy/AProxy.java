package com.myy.static_proxy.proxy;

import com.myy.static_proxy.interfaces.A;

/**
 * 静态代理类
 */
public class AProxy implements A {

    // 获取A接口的实现类对象
    private A aimpl;

    public AProxy(A aimpl) {
        this.aimpl = aimpl;
    }

    // 接口的所有方法都扩展该方法
    private void plus(){
        System.out.println("代理类的扩展内容执行!");
    }

    @Override
    public int method1(int n) {
        plus();
        int i = aimpl.method1(n);
        return i;
    }

    @Override
    public String method2(String str) {
        plus();
        String s = aimpl.method2(str);
        return s;
    }

}
