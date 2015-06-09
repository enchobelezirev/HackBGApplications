
public class ThreadBQueue extends Thread {
    private BlockingQueue<Integer> blockedQueue = null;
    public ThreadBQueue(BlockingQueue<Integer> q) {
        this.blockedQueue = q;
    }
    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            this.blockedQueue.offer(5);
            try {
                ThreadBQueue.sleep(2000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
