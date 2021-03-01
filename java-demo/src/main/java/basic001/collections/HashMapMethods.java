package basic001.collections;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.BiConsumer;

/**
 * map集合获取key-vlaue的方法:
 * map.entrySet()获取Set<Map.Entry<? super K, ? super V>>
 * map.keySet()获取Set<K>
 * map.values()获取Collection<V>
 * <p>
 * map.forEach方法是对entrySet的封装
 * <p>
 * 通过迭代器遍历
 *
 * 如果需要在遍历集合的时候对象集合中元素进行删除操作，需要使用iterator的遍历方式
 */
public class HashMapMethods {
    public static Map<String, String> map = new HashMap<>();

    static {
        map.put("aa", "aaa");
        map.put("bb", "bbb");
        map.put("cc", "ccc");
        map.put("dd", "ddd");
        map.put("ee", "eee");
    }

    /**
     * map.entrySet()获取map集合中条目:键值对
     */
    @Test
    public void test1() {
        Set<Map.Entry<String, String>> entries = map.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            if ("cc".equals(entry.getKey())) {
                System.out.println(entry.getValue());
            }
        }
    }

    /**
     * 先遍历map.keySet()集合找到Key值再通过map.get(key)方法获取对应的value
     * 此方法全部遍历时:每次都需要二次查找效率较低
     * <p>
     * map.v
     */
    @Test
    public void test2() {
        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            if ("cc".equals(key)) {
                System.out.println(map.get(key));
            }
        }
    }

    /**
     * 如果只需要遍历value值,可以直接通过map.values()方法直接获取value值
     */
    @Test
    public void test3() {
        Collection<String> values = map.values();
        for (String value : values) {
            System.out.println(value);
        }
    }

    /**
     * entry<String,String>
     */
    @Test
    public void test4() {
        map.forEach((key, value) -> {
            System.out.println(key + ":" + value);
        });
    }

    /**
     * map.keySet().iterator
     */
    @Test
    public void test5() {
        Iterator<String> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            System.out.println(key + ":" + map.get(key));
        }
    }

    /**
     * map.entrySet().iterator
     */
    @Test
    public void test6() {
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        System.out.println(map);
    }
}






























