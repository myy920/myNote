package basic001.abstract_demo;


/**
 * 抽象类:
 * 1.抽象类和普通类基本一样,唯一的区别是抽象类不能被实例化和可以含有抽象方法
 * 2.含有抽象方法的类一定是抽象类
 */
public abstract class MyAbstract {

    private static String a;

    static {

    }

    public abstract void doSome1();
    private void doSome2(){
        System.out.println(2);
    }
}
