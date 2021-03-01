package basic001.Thread.thread_3_synchronized;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TicketRunnable_lock implements Runnable {


    private int tickets;
    private Lock lock = new ReentrantLock();

    public TicketRunnable_lock(int tickets) {
        this.tickets = tickets;
    }

    @Override
    public void run() {
        while (true) {
            lock.lock();
            if (tickets > 0) {
                System.out.println(Thread.currentThread().getName() + "->" + tickets--);
                lock.unlock();
            }else {
                lock.unlock();
                break;
            }

        }

    }
}
