package basic001.Thread.thread_2_Runnable;

public class MyRunnable implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName()+"->"+i);
        }
    }
}
