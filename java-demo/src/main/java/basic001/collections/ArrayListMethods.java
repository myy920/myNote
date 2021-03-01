package basic001.collections;

import commons.Cat;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;


/**
 * ArrayList的方法:
 * list.add()
 * list.remove()
 * list.size()
 * list.iterator()
 * list.get()
 * list.clear()
 * list.indexOf()
 * list.lastIndexOf()
 * list.sort()
 */
public class ArrayListMethods {
    public static ArrayList<Cat> cats = new ArrayList<>();

    static {
        cats.add(new Cat(1,"小黑", "黑色", 5));
        cats.add(new Cat(2,"小白", "白色", 3));
        cats.add(new Cat(3,"小黄", "黄色", 6));
        cats.add(new Cat(4,"二花", "黑白", 4));
        cats.add(new Cat(5,"三花", "黑白黄", 4));
        cats.add(new Cat(6,"花花", "黄白", 7));
        cats.sort((o1, o2) -> {
                    if (o1.getAge() == o2.getAge()) {
                        return 0;
                    } else {
                        return o1.getAge() > o2.getAge() ? 1 : -1;
                    }
                }
        );
    }

    /**
     * for循环遍历
     */
    @Test
    public void test1() {
        for (int i = 0; i < cats.size(); i++) {
            if ("二花".equals(cats.get(i).getName())) {
                System.out.println(cats.get(i));
                cats.remove(i);
            }
        }
        System.out.println(cats);
    }

    /**
     * for循环遍历: 该循环中不删除元素
     */
    @Test
    public void test2() {
        for (Cat cat : cats) {
            if ("二花".equals(cat.getName())) {
                System.out.println(cat);
            }
        }
    }

    /**
     * 迭代器遍历
     */
    @Test
    public void test3() {
        Iterator<Cat> iterator = cats.iterator();
        while (iterator.hasNext()) {
            Cat cat = iterator.next();
            if ("二花".equals(cat.getName())) {
                iterator.remove();
            }
        }
        System.out.println(cats);
    }
}




























