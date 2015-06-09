

public class ThreadAQueue extends Thread {
    private BlockingQueue<Integer> blockedQueue = null;
    public ThreadAQueue(BlockingQueue<Integer> q) {
        this.blockedQueue = q;
    }
    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println(this.blockedQueue.poll());
            try {
                ThreadAQueue.sleep(2000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
       
    }

}
