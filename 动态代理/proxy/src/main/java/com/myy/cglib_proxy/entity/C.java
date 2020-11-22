package com.myy.cglib_proxy.entity;

public class C {

    public int method1(int n) {
        System.out.println("CImpl1的method1执行并返回结果:"+n);
        return n;
    }

    public String method2(String s) {
        System.out.println("CImpl1的method2执行并返回结果:"+s);
        return s;
    }
}
