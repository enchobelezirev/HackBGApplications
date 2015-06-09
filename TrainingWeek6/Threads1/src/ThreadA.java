public class ThreadA implements Runnable {
    private Counter counter;

    public ThreadA(Counter c) {
        this.counter = c;
    }

    @Override
    public void run() {
        try {
            counter.increment();
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
