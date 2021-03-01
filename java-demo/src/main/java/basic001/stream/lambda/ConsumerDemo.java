package basic001.stream.lambda;

import org.junit.jupiter.api.Test;

import java.util.function.Consumer;

public class ConsumerDemo {

    private static void accept(String str, Consumer<String> consumer) {
        consumer.accept(str);
    }

    private static void andThen(String str, Consumer<String> con1, Consumer<String> con2) {
        con1.andThen(con2).accept(str);
    }

    private static void andThen(String[] strings, Consumer<String> con1, Consumer<String> con2) {
        for (int i = 0; i < strings.length; i++) {
            con1.andThen(con2).accept(strings[i]);
        }
    }

    /**
     * accept方法
     */
    @Test
    public void test1() {
        String string = "abcdefg";
        accept(string, (str) -> {
            StringBuilder sb = new StringBuilder(str);
            System.out.println(sb.reverse().toString());
        });
    }

    /**
     * andThen方法
     */
    @Test
    public void test2() {
        String string = "afFDSFfsdFD";
        andThen(string,
                s -> {
                    System.out.println(s.toUpperCase());
                },
                s -> {
                    System.out.println(s);
                    System.out.println(s.toLowerCase());
                }
        );
    }

    /**
     * andThen方法格式化打印信息
     */
    @Test
    public void test3() {
        String[] strings = {"小米,女", "铁蛋,男", "二狗,男"};
        andThen(strings,
                s -> {
                    System.out.print("姓名:"+s.split(",")[0]+",");
                },
                s -> {
                    System.out.println("性别:"+s.split(",")[1]+"");
                }
        );
    }
}












