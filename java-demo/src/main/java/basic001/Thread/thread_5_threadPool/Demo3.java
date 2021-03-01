package basic001.Thread.thread_5_threadPool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Demo3 {
    public static void main(String[] args) {
        //定长线程，按时执行任务
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);
        scheduledExecutorService.schedule(new RunnableImpl(),1, TimeUnit.SECONDS);
    }
}
