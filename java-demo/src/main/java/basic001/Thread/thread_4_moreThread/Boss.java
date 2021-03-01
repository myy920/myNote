package basic001.Thread.thread_4_moreThread;

public class Boss implements Runnable {

    private Object object;

    public Boss(Object object) {
        this.object = object;
    }

    @Override
    public void run() {
        try {
            while (true) {

                synchronized (object) {
                    object.wait();
                    Thread.sleep(1000);
                    System.out.println("我开始做包子了,您稍等!");
                    Thread.sleep(1000);
                    System.out.println("5分钟...");
                    object.notify();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
