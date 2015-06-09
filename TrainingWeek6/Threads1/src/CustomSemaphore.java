public class CustomSemaphore {
    private Thread thread;
    private boolean available = true;

    public CustomSemaphore() {
        this.thread = null;
    }

    public void aquire() throws InterruptedException {
        while (!this.available) {
            synchronized (this) {
                this.wait();
            }
            System.out.println("Waiting : " + Thread.currentThread().getName());
        }
        thread = Thread.currentThread();
        this.available = true;
        System.out.println("Set instance of: " + thread.getName());

    }

    public void release() {
        synchronized (this) {
            System.out.println("unlock :" + thread.getName());
            this.notifyAll();
            thread = null;
            this.available = false;
        }
    }
}
