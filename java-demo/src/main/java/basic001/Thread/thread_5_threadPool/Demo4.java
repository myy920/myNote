package basic001.Thread.thread_5_threadPool;

import org.omg.CORBA.Object;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo4 {
    public static void main(String[] args) throws InterruptedException {
        //创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        List<Callable<Object>> list = new ArrayList<>();
        list.add(()-> {System.out.println(1);return null;});
        list.add(()-> {System.out.println(2);return null;});
        list.add(()-> {System.out.println(3);return null;});
        list.add(()-> {System.out.println(4);return null;});
        list.add(()-> {System.out.println(5);return null;});
        list.add(()-> {System.out.println(6);return null;});

        executorService.invokeAll(list);
        executorService.shutdown();
    }

}
