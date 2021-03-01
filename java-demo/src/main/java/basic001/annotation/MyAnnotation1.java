package basic001.annotation;


import java.lang.annotation.*;

@Target(ElementType.TYPE)//表示该注解作用在何处
@Retention(RetentionPolicy.RUNTIME)//表示该注解保留到哪个阶段
@Documented//表示该注解生产doc文档
@Inherited//表示该注解作用的类的子类也带有该注解
public @interface MyAnnotation1 {
    /*
    * 注解里面只能有 String,int,enum,注解四个类型的返回值
    *
    * */
    String name() default "";
    String[] names() default "";
    int number() default 0;
    int numbers() default 0;
    MyType value() default MyType.ONE;
    //MyAnnotation2 myAnnotation2();
}
