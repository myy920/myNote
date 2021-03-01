package basic001.annotation;

public class TestClass {

    @MyTest
    public void test1() {
        System.out.println("执行test1方法");
    }

    @MyTest
    public void test2() {
        int a = 1/0;
        System.out.println("执行test2方法");
    }

    @MyTest
    public void test3() {
        System.out.println("执行test3方法");
    }
    @MyTest
    public void test4() {
        int a = 1/0;
        System.out.println("执行test4方法");
    }
}
