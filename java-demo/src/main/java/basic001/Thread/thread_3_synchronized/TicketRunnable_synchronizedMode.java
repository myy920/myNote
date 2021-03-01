package basic001.Thread.thread_3_synchronized;

public class TicketRunnable_synchronizedMode implements Runnable {

    private int tickets;

    public TicketRunnable_synchronizedMode(int tickets) {
        this.tickets = tickets;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                if (tickets > 0) {
                    System.out.println(Thread.currentThread().getName() + "->" + tickets--);
                }else {
                    break;
                }
            }
        }
    }
}
