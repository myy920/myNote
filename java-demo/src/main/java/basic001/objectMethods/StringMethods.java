package basic001.objectMethods;

import org.junit.jupiter.api.Test;

public class StringMethods {


    @Test
    public void test1() {
        String str = ";;aa;;";
        String substring = str.substring(2, 2);
        System.out.println(substring);


        String[] split = str.split(";",10);
        System.out.println(split.length);
    }
}
