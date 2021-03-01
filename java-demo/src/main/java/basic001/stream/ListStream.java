package basic001.stream;

import commons.Cat;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class ListStream {

    private static List<Cat> list = new ArrayList<>();

    static {
        list.add(new Cat(1, "花花", "黑白", 2));
        list.add(new Cat(2, "小花", "黑", 2));
        list.add(new Cat(3, "大花", "黑白", 4));
        list.add(new Cat(4, "三花", "黑白黄", 4));
        list.add(new Cat(5, "阿黄", "黄", 4));
    }

    /**
     * 不用lambda表达式
     */
    @Test
    public void test1() {
        list.stream()
                .filter(new Predicate<Cat>() {
                    @Override
                    public boolean test(Cat cat) {
                        return cat.getName().contains("花");
                    }
                })
                .filter(new Predicate<Cat>() {
                    @Override
                    public boolean test(Cat cat) {
                        return cat.getColor().contains("黑白");
                    }
                })
                .forEach(new Consumer<Cat>() {
                    @Override
                    public void accept(Cat cat) {
                        System.out.println(cat);
                    }
                });
    }

    /**
     * Collecion.stream()获取顺序流
     */
    @Test
    public void test2() {
        list.stream()
                .forEach(
                        cat -> System.out.println(cat)
                );
    }

    /**
     * Collection.prallelStream()获取并行流
     */
    @Test
    public void test3() {
        list.parallelStream()
                .forEach(
                        cat -> System.out.println(cat)
                );
    }

    /**
     * 延迟方法:
     * filter方法:对stream流中元素进行过滤
     */
    @Test
    public void test4() {
        Stream<Cat> stream = list.stream();
        Stream<Cat> catStream = stream.filter(cat -> cat.getAge() == 4);
        catStream.forEach(cat -> System.out.println(cat));
    }

    /**
     * 延迟方法:
     * map方法:将stream1流映射成stream2流
     */
    @Test
    public void test5() {
        Stream<Cat> stream = list.stream();
        Stream<String> stringStream = stream.map((s) -> s.getName());
        stringStream.forEach(catName -> System.out.println(catName));
    }

    /**
     * 延迟方法:
     * limit方法:拦截前几个返回被拦截的stream流
     */
    @Test
    public void test6() {
        Stream<Cat> stream = list.stream();
        Stream<Cat> limitStream = stream.limit(3);
        limitStream.forEach(cat -> System.out.println(cat));
    }

    /**
     * 延迟方法:
     * skip方法:跳过前几个,返回后面的stream流
     */
    @Test
    public void test7() {
        Stream<Cat> stream = list.stream();
        Stream<Cat> limitStream = stream.skip(3);
        limitStream.forEach(cat -> System.out.println(cat));
    }
    /**
     * 延迟方法:
     * concat方法:将两个stream合并成一个stream流
     */
    @Test
    public void concat(){
        Stream<Character> stream1 = Stream.of('a', 'b', 'c');
        Stream<Character> stream2 = Stream.of('e', 'f');
        Stream<Character> concat = Stream.concat(stream1, stream2);
        concat.forEach(character -> System.out.println(character));
    }
    /**
     * 终结方法:
     * count 和 foreach
     */
    @Test
    public void count(){
        long count = list.stream().count();
        System.out.println(count);
    }





}




























