package basic001.stream.lambda;


import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Demo {
    /**
     * MyLambda
     */
    @Test
    public void test1() {
        MyLambda ml = (str -> System.out.println(str));
        ml.doSome("aaa");
        System.out.println(ml == null ? 1 : 2);

    }

    /**
     * CustomComparator
     */
    @Test
    public void test2() {
        String[] strings = new String[]{"aaa","bb","cccccc","ddd","eeeee"};
        Arrays.sort(strings,CustomComparator.getComparator());
        for (int i = 0; i < strings.length; i++) {
            System.out.println(strings[i]);
        }
    }
}
