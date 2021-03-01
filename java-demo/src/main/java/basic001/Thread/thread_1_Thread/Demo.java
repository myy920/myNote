package basic001.Thread.thread_1_Thread;



public class Demo {
    public static void main(String[] args) {
        MyThread thread1 = new MyThread();
        MyThread thread2 = new MyThread();
        thread1.setName("线程1号");
        thread2.setName("线程2号");
        thread1.start();
        thread2.start();

    }
}
