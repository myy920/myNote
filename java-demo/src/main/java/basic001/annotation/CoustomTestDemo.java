package basic001.annotation;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CoustomTestDemo {
    public static void main(String[] args) throws IOException {
        TestClass tc = new TestClass();
        Method[] methods = tc.getClass().getMethods();

        //定义一个缓冲区记录异常信息
        int count = 0;
        BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\myy\\Desktop\\java-demo\\src\\main\\java\\basic001\\annotation\\bug.txt"));
        for (Method method : methods) {

            if (method.isAnnotationPresent(MyTest.class)) {
                try {
                    method.invoke(tc);
                } catch (Exception e) {
                    count++;
                    bw.write(method.getName()+"方法出现异常!");
                    bw.newLine();
                    bw.write("异常名称:"+e.getCause().getClass().getSimpleName());
                    bw.newLine();
                    bw.write("异常原因:"+e.getCause().getMessage());
                    bw.newLine();
                    bw.write("------------------------------");
                    bw.newLine();
                }
            }
        }
        bw.write("本次一共出现"+count+"次异常!");
        bw.flush();
        bw.close();
    }
}
