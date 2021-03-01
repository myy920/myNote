package basic001.Thread.thread_5_threadPool;

import java.util.Random;


public class RunnableImpl implements Runnable{

    @Override
    public void run() {
        try {
            //int time = new Random().nextInt(5000);
            int time = 1000;
            Thread.sleep(time);
            System.out.println(Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
