package encho_belezirev;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public abstract class ImmutableAbstract<T> implements List<T> {

    protected List<T> dataList = new ArrayList<>();

    @Override
    public boolean add(T e) {
        // TODO Auto-generated method stub
        return this.dataList.add(e);
    }

    @Override
    public void add(int index, T element) {
        this.dataList.add(index, element);
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        // TODO Auto-generated method stub
        return this.dataList.addAll(c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        // TODO Auto-generated method stub
        return this.dataList.addAll(index, c);
    }

    @Override
    public void clear() {
        this.dataList.clear();
    }

    @Override
    public boolean contains(Object o) {
        // TODO Auto-generated method stub
        return this.dataList.contains(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        // TODO Auto-generated method stub
        return this.dataList.containsAll(c);
    }

    @Override
    public T get(int index) {
        // TODO Auto-generated method stub
        
        return this.dataList.get(index);
    }

    @Override
    public int indexOf(Object o) {
        // TODO Auto-generated method stub
        return this.dataList.indexOf(o);
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return this.dataList.isEmpty();
    }

    @Override
    public Iterator<T> iterator() {
        // TODO Auto-generated method stub
        return this.iterator();
    }

    @Override
    public int lastIndexOf(Object o) {
        // TODO Auto-generated method stub
        return this.dataList.lastIndexOf(o);
    }

    @Override
    public ListIterator<T> listIterator() {
        // TODO Auto-generated method stub
        return this.dataList.listIterator();
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        // TODO Auto-generated method stub
        return this.dataList.listIterator(index);
    }

    @Override
    public boolean remove(Object o) {
        // TODO Auto-generated method stub
        return this.remove(o);
    }

    @Override
    public T remove(int index) {
        // TODO Auto-generated method stub
        return this.remove(index);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        // TODO Auto-generated method stub
        return this.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        // TODO Auto-generated method stub
        return this.dataList.retainAll(c);
    }

    @Override
    public T set(int index, T element) {
        // TODO Auto-generated method stub
        return this.dataList.set(index, element);
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return this.dataList.size();
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        // TODO Auto-generated method stub
        return this.dataList.subList(fromIndex, toIndex);
    }

    @Override
    public Object[] toArray() {
        // TODO Auto-generated method stub
        return this.dataList.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        // TODO Auto-generated method stub
        return (T[]) this.dataList.toArray();
    }

}