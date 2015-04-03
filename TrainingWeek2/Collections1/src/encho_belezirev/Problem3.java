package encho_belezirev;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem3<T> implements Queue<T> {
    private Queue<T> dataList; 
    private int elementsToShow;
    private int indexElement;
    
    public Problem3(int elementsToShow) {
        this.dataList = new LinkedList<T>();
        this.elementsToShow = elementsToShow;
    }
    @Override
    public boolean addAll(Collection<? extends T> c) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean contains(Object o) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean remove(Object o) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Object[] toArray() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean add(T arg0) {
        
        return false;
    }

    @Override
    public T element() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean offer(T arg0) {
        this.dataList.add(arg0);
        for (int i = 0; i < dataList.size() - this.elementsToShow; i++) {
            this.dataList.poll();
            return true;
        }
        return false;
    }

    @Override
    public T peek() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public T poll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public T remove() {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Iterator<T> iterator = dataList.iterator();
        while (iterator.hasNext()) {
            T t = (T) iterator.next();
            builder.append(t.toString() +" ");
            
        }
        
        return builder.toString();
    }

}
