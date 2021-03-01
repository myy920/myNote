package basic001.Thread.thread_5_threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Demo2 {
    public static void main(String[] args) {
        //创建一个可缓存的线程池，有空闲线程就回收，需要线程就创建
        ExecutorService executorService = Executors.newCachedThreadPool();
        Runnable runnable = new RunnableImpl();
        for (int i = 0; i < 100; i++) {
            executorService.submit(runnable);
        }
        executorService.shutdown();
    }
}
