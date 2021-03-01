package basic001.Interface_demo;

import java.util.ArrayList;
import java.util.List;

public interface A {

    public abstract void doSome();

    default void doSome1(){
        System.out.println("doSome1");
    }

}
