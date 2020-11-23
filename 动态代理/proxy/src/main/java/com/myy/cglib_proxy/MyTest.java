package com.myy.cglib_proxy;

import com.myy.cglib_proxy.entity.C;
import com.myy.cglib_proxy.factory.ProxyFactory;
import org.junit.jupiter.api.Test;

/**
 * cglib的动态代理原理是继承: 把被代理对象类的class文件加载进来,修改其字节码文件生成一个继承了被代理类的子类.
 *      注意: 修改了字节码,所以需要依赖ASM包,使用cglib就是为了弥补动态代理的不足.
 *
 * 在spring的AOP编程中,如果加入容器的目标对象有实现接口,就用JDK代理;如果目标对象没有实现接口,就用cglib代理
 *
 * 1.aspectj是静态织入,使用的是静态代理,在编译器通过aspectj的编译器生成代理类,运行速度快
 * 2.ASM是一个字节码操作工具,静态还是动态就看在哪个阶段使用
 * 3.动态织入: 作用于编译器,字节码加载之后,使用了反射,性能比静态织入要差一些; springAOP底层使用了JDK动态代理和CgLIB动态代理,
 *              Jdk代理针对有接口的类,CGlib针对无接口可以继承的类是对jdk代理的补充
 * 4.实际上,spring只是使用了与Aspectj一样的注解,没有使用Aspectj编译器,转向采用动态代理技术实现原理构建springAOP的内部机制(动态织入),
 *      这是和Aspectj( 静态织入)最根本的区别.
 *
 */
public class MyTest {
    @Test
    public void test1(){
        C c = new C();
        ProxyFactory factory = new ProxyFactory(c);
        Object proxy = factory.getProxy();
        if (proxy instanceof C){
            C cProxy = (C)proxy;
            int i = cProxy.method1(789);
        }
    }

}
