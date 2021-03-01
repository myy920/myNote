package basic001.Thread.thread_4_moreThread;

/**
 * object的方法,wait(),notify(),notityAll()需在有锁的情况下执行
 * Thread的sleep()方法,使线程睡眠但是不会归还锁,而wait()方法会归还锁
 *
 * 线程状态:        new(新建状态)-->run(运行状态)<==>(阻塞状态)<==>wait(等待状态)<==>sleep(睡眠状态)<==>死亡状态
 *
 *
 *
 */
public class Demo {
    public static void main(String[] args) throws InterruptedException {
        Object object = new Object();
        Consumer consumer = new Consumer(object);
        Boss boss = new Boss(object);

        new Thread(boss).start();
        Thread.sleep(10);
        new Thread(consumer).start();

    }
}
