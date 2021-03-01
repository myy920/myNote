package basic001.annotation;


@SuppressWarnings("all")//压制警告
public class Demo {

    @Deprecated//过期注解
    public static void method1(){
        System.out.println("method1");
    }

    public static void main(String[] args) {
        method1();
    }
}
