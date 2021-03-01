package basic001.objectMethods;

import org.junit.jupiter.api.Test;

public class ObjectMethod {


    @Test
    public void test1() throws InterruptedException {
        Object object = new Object();
        boolean equals = object.equals(1);
        int i = object.hashCode();
        String s = object.toString();
        Class<?> aClass = object.getClass();
        object.notify();
        object.wait();
    }
}
