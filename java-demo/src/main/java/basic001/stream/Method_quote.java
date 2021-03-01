package basic001.stream;

import commons.Cat;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Method_quote {
    private static List<Cat> list = new ArrayList<>();

    static {
        list.add(new Cat(1, "花花", "黑白", 2));
        list.add(new Cat(2, "小花", "黑", 2));
        list.add(new Cat(3, "大花", "黑白", 4));
        list.add(new Cat(4, "三花", "黑白黄", 4));
        list.add(new Cat(5, "阿黄", "黄", 4));
    }

    @Test
    public void test1() {
        //lambda表达式
        list.stream().forEach(cat -> System.out.println("lambda-->"+cat));
        //方法引用简化lambda表达式
        list.stream().forEach(System.out::println);

        //方法引用:通过类名引用静态方法
        list.stream().forEach(Cat::staticWhoCat);

        //方法引用:通过对象引用成员方法
        Cat cat = new Cat();
        list.stream().forEach(cat::whoCat);

        //方法引用:调用父类方法  super::method
        //方法应用:调用本类的方法  this::method

    }
}






























