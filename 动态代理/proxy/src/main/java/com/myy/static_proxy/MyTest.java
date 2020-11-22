package com.myy.static_proxy;

import com.myy.static_proxy.entity.AImpl1;
import com.myy.static_proxy.entity.AImpl2;
import com.myy.static_proxy.proxy.AProxy;
import org.junit.jupiter.api.Test;

/**
 * 静态代理:
 *      优点: 可以做到在不修改目标对象的功能前提下,对目标功能进行扩展
 *      缺点: 需要和目标对象一样实现接口的代理类,一旦接口增加方法目标对象和代理类都需要维护
 */
public class MyTest {

    @Test
    public void test1(){
        AImpl1 a1 = new AImpl1();
        // 生成aChild1的代理类
        AProxy aProxy = new AProxy(a1);
        int i = aProxy.method1(123);
        String aaa = aProxy.method2("aaa");
    }

    @Test
    public void test2(){
        AImpl2 a2 = new AImpl2();
        // 生成aChild2的代理类
        AProxy aProxy = new AProxy(a2);
        int i = aProxy.method1(456);
        String aaa = aProxy.method2("bbb");
    }


}
