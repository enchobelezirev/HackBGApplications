import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueue<T extends Number> implements Queue<T> {
    private Queue<T> queue = new LinkedList<T>();
    private int limit = 10;

    @Override
    public boolean addAll(Collection<? extends T> arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean contains(Object arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isEmpty() {
        return this.queue.isEmpty();
    }

    @Override
    public Iterator<T> iterator() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean remove(Object arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return this.queue.size();
    }

    @Override
    public Object[] toArray() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <T> T[] toArray(T[] arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean add(T arg0) {
        // TODO Auto-generated method stub
        return this.queue.add(arg0);
    }

    @Override
    public T element() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean offer(T arg0) {
        this.limit++;
        synchronized (this.queue) {
            while (!this.queue.isEmpty() && this.limit >= 10) {
                try {
                    this.queue.wait();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            this.queue.notifyAll();
            System.out.println("Adding with: " + Thread.currentThread().getName());
            this.queue.offer(arg0);
        }

        return true;
    }

    @Override
    public T peek() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public T poll() {
        this.limit--;
        synchronized (this.queue) {
            while (this.queue.isEmpty() && this.limit <= 0) {
                try {
                    this.queue.wait();
                    System.out.println("Waiting with : " + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.queue.notifyAll();
        }

        return this.queue.poll();
    }

    @Override
    public T remove() {
        return null;
    }

}
