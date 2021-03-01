package basic001.Thread.thread_6_callable;

import java.util.concurrent.*;

public class Demo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(3);
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(3000);
                return "CALL";
            }
        };
        Future<String> future = pool.submit(callable);
        String s = future.get();
        System.out.println(s);
    }
}
