public class ThreadB implements Runnable {
    private Counter counter;

    public ThreadB(Counter c) {
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
