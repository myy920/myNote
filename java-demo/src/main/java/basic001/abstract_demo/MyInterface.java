package basic001.abstract_demo;

/**
 * 接口是抽象方法的集合,可以含有 'public static'修饰的成员变量
 * 不可以含有静态方法
 */
public interface MyInterface {

    public static String name = "jojo";

    public abstract void doSome1();

    /**
     * jdk1.8可以给接口添加默认方法和静态方法
     */
    public default void doSome2() {
        System.out.println("这是一个默认方法");
    }

    public static void doSome3() {
        System.out.println("这是一个静态方法");
    }
}
