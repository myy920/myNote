package basic001.collections;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HashSetMethods {

    private static List<Integer> list = new ArrayList<>();
    private static Set set = new HashSet();

    static {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(1);
        list.add(4);
    }

    /**
     * list集合去重
     */
    @Test
    public void test1() {
        set.addAll(list);
        System.out.println(set);
    }

}
