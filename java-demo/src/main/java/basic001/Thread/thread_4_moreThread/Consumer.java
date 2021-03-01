package basic001.Thread.thread_4_moreThread;

public class Consumer implements Runnable {

    private Object object;

    public Consumer(Object object) {
        this.object = object;
    }

    @Override
    public void run() {
        try {
            while (true) {
                synchronized (object) {
                    System.out.println("老板来个包子,我在这等着!");
                    object.notify();
                    object.wait();
                    Thread.sleep(1000);
                    System.out.println("包子真好吃!");
                    System.out.println("=======================");
                    Thread.sleep(2000);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
