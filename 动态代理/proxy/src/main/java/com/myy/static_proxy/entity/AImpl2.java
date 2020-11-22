package com.myy.static_proxy.entity;

import com.myy.static_proxy.interfaces.A;

public class AImpl2 implements A {


    @Override
    public int method1(int n) {
        System.out.println("AImpl2的method1执行且返回结果:"+n);
        return n;
    }

    @Override
    public String method2(String str) {
        System.out.println("AImpl2的method2执行且返回结果:"+str);
        return str;
    }
}
