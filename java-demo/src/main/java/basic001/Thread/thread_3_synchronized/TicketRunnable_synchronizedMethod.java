package basic001.Thread.thread_3_synchronized;

public class TicketRunnable_synchronizedMethod implements Runnable {

    private int tickets;

    public TicketRunnable_synchronizedMethod(int tickets) {
        this.tickets = tickets;
    }

    /**
     * 同步方法
     */
    @Override
    public synchronized void run() {
        while (tickets > 0) {
            System.out.println(Thread.currentThread().getName() + "->" + tickets--);
        }
    }

}
