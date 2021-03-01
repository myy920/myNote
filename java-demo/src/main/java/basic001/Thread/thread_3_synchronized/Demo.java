package basic001.Thread.thread_3_synchronized;

import org.junit.jupiter.api.Test;

public class Demo {

    /**
     * 同步方法
     */
    @Test
    public void test1() {
        TicketRunnable_synchronizedMethod tr = new TicketRunnable_synchronizedMethod(100);
        new Thread(tr).start();
        new Thread(tr).start();
        new Thread(tr).start();
    }

    /**
     * 同步代码块
     */
    @Test
    public void test2() {
        TicketRunnable_synchronizedMode tr = new TicketRunnable_synchronizedMode(100);
        new Thread(tr).start();
        new Thread(tr).start();
        new Thread(tr).start();
    }

    /**
     * lock锁
     */
    @Test
    public void test3() {
        TicketRunnable_lock tr = new TicketRunnable_lock(100);
        new Thread(tr).start();
        new Thread(tr).start();
        new Thread(tr).start();
    }
}


















