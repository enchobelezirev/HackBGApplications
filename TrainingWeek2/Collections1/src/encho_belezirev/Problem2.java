package encho_belezirev;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Problem2<E> extends Problem1 implements Collection<E>{

    private List<E> dataList;
    
    public Problem2(){
        dataList = new ArrayList<E>();
    }
    
    public E getElement(int index){
        return this.dataList.get(index);
    }
    @Override
    public boolean add(E e) {
        if (dataList.contains(e)) {
            //remove all the objects equal to e
            for(E element: dataList){
                if (element == e) {
                    dataList.remove(element);
                }
            }
            return false;
        }
        dataList.add(e);
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return  this.dataList.addAll(c);
    }

    @Override
    public void clear() {
        this.dataList.clear();
    }

    @Override
    public boolean contains(Object o) {
        return this.dataList.contains(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        // TODO Auto-generated method stub
        return this.dataList.containsAll(c);
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return this.dataList.isEmpty();
    }

    @Override
    public Iterator<E> iterator() {
        // TODO Auto-generated method stub
        return this.dataList.iterator();
    }

    @Override
    public boolean remove(Object o) {
        // TODO Auto-generated method stub
        return this.dataList.remove(o);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        // TODO Auto-generated method stub
        return this.dataList.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        // TODO Auto-generated method stub
        return this.dataList.removeAll(c);
    }

    @Override
    public int size() {
        return this.dataList.size();
    }

    @Override
    public Object[] toArray() {
        // TODO Auto-generated method stub
        return this.dataList.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        // TODO Auto-generated method stub
        return this.dataList.toArray(a);
    }

}
