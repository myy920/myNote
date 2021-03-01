package basic001.Thread.thread_2_Runnable;

public class Demo {
    public static void main(String[] args) {
        //线程1
        MyRunnable run = new MyRunnable();
        Thread thread1 = new Thread(run);
        thread1.start();

        //线程2
        new Thread(new MyRunnable()).start();
    }
}
