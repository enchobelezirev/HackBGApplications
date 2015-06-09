
public class Counter {
    private int counter =0;
    private CustomSemaphore lock = null;
    
    public Counter() {
        lock = new CustomSemaphore();
    }

    public void increment() throws InterruptedException {
        lock.aquire();
        counter++;
        lock.release();
    }

    public void decrenment() throws InterruptedException {
        lock.aquire();
        counter--;
        lock.release();
    }

    public synchronized int returnCounter() {
        return counter;
    }

}
