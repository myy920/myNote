package basic001.stream.lambda;

import org.junit.jupiter.api.Test;

import java.util.function.Function;

public class FunctionDemo {

    private static int applay(String str, Function<String, Integer> fun) {
        return fun.apply(str);
    }

    private static boolean andThen(String str, Function<String, Integer> fun1, Function<Integer, Boolean> fun2) {
        return fun1.andThen(fun2).apply(str);
    }

    private static int compose(String str, Function<String, String> fun1, Function<String, Integer> fun2) {
        return fun2.compose(fun1).apply(str);
    }

    private static int andThen(String str,
                               Function<String, String> fun1,
                               Function<String, Integer> fun2,
                               Function<Integer, Integer> fun3) {
        return fun1.andThen(fun2).andThen(fun3).apply(str);
    }

    @Test
    public void test1() {
        String str = "fdsfdsgdf";
        int len = applay(str, s -> s.length());
        System.out.println(len);
    }

    @Test
    public void test2() {
        String str = "sdfglkadsf";
        boolean b = andThen(str, s -> s.length(), length -> length > 5);
        System.out.println(b);
    }

    @Test
    public void test3() {
        String s = "abcd";
        int len = compose(s, s1 -> s1 + "ef", s2 -> s2.length());
        System.out.println(len);
    }

    /**
     * String s = "张大炮,23";
     * 1.截取年龄部分
     * 2.将年龄部分字符串转成int类型
     * 3.将该数值加100返回
     */
    @Test
    public void test4() {
        String s = "张大炮,23";
        int n = andThen(s, s1 -> s1.split(",")[1], s2 -> Integer.valueOf(s2), i3 -> i3 + 100);
        System.out.println(n);
    }
}
