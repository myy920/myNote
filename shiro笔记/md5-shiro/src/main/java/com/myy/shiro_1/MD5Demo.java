package com.myy.shiro_1;

import org.apache.shiro.crypto.hash.Md5Hash;

public class MD5Demo {
    public static void main(String[] args) {
        //md5
        Md5Hash md5Hash = new Md5Hash("123");
        System.out.println(md5Hash.toHex());
        System.out.println("----------------");

        //md5+salt
        Md5Hash md5Hash1 = new Md5Hash("123","abc");
        System.out.println(md5Hash1.toHex());
        System.out.println("----------------");

        //md5+salt+hash散列次数
        Md5Hash md5Hash2 = new Md5Hash("123","abc",1024);
        System.out.println(md5Hash2.toHex());
        System.out.println("----------------");
    }
}
