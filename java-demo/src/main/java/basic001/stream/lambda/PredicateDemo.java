package basic001.stream.lambda;

import org.junit.jupiter.api.Test;

import java.util.function.Predicate;

public class PredicateDemo {

    private static boolean test(String str, Predicate<String> pre) {
        return pre.test(str);
    }

    private static boolean and(String str, Predicate<String> pre1, Predicate<String> pre2) {
        return pre1.and(pre2).test(str);
    }

    private static boolean or(String str, Predicate<String> pre1, Predicate<String> pre2) {
        return pre1.or(pre2).test(str);
    }

    private static boolean negate(String str, Predicate<String> pre) {
        return pre.negate().test(str);
    }

    private static boolean and2(String str, Predicate<String> pre1, Predicate<String> pre2) {
        return pre1.and(pre2).test(str);
    }

    /**
     * test方法->判断字符串长度是否大于5
     */
    @Test
    public void test1() {
        String string = "fsdfasf";
        boolean b = test(string,
                s -> {
                    return s.length() > 5;
                }
        );
        System.out.println(b);
    }

    /**
     * and方法->判断字符串长度大于5且包含字符'a'  &&
     */
    @Test
    public void test2() {
        String string = "fsdfasf";
        boolean b = and(string,
                s -> {
                    return s.length() > 5;
                }, s -> {
                    return s.contains("a");
                }
        );
        System.out.println(b);
    }

    /**
     * or方法->满足一个方法 ||
     */
    @Test
    public void test3() {
        String string = "fsdfaa";
        boolean b = or(string,
                s -> s.length() > 5
                ,
                s -> s.contains("a")
        );
        System.out.println(b);
    }

    /**
     * nagete方法->取反  !
     */
    @Test
    public void test4() {
        String string = "sfagggfd";
        boolean b = negate(string, string1 -> string1.length() > 5);
        System.out.println(b);
    }

    /**
     * 集合的筛选:名字三个字且为男
     */
    @Test
    public void test5() {
        String[] strings = {"张飞,男", "诸葛亮,男", "曹孟德,男", "黄月英,女"};
        for (String string : strings) {
            if (and(string,
                    s -> s.split(",")[0].length() == 3,
                    s -> "男".equals(s.split(",")[1]))) {
                System.out.println(string);
            }
        }

    }
}



















 




