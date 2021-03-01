package basic001.Thread.thread_5_threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Demo1 {

    public static void main(String[] args) {
        //创建定长线程池，超出的线程会在队列中等待
        ExecutorService executor = Executors.newFixedThreadPool(9);
        Runnable runnable = new RunnableImpl();
        long t1 = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            executor.submit(runnable);
        }
        executor.shutdown();
        long t2 = System.currentTimeMillis();
        System.out.println(t2-t1);
    }
}
