package com.myy.dynamic_proxy.entity;

import com.myy.dynamic_proxy.interfaces.B;

public class BImpl2 implements B {

    @Override
    public int method1(int n) {
        System.out.println("BImpl2的method1执行并返回结果:"+n);
        return n;
    }

    @Override
    public String method2(String s) {
        System.out.println("BImpl2的method2执行并返回结果:"+s);
        return s;
    }
}
