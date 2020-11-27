package com.myy;

import org.junit.Test;

public class Demo1 {
    @Test
    public void test1(){
        int h;
        int i = (h = 1321313) ^ (h >>> 16);
        System.out.println(i);
    }

}
