package encho_belezirev;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.SerializationUtils;

public class Immutable<T extends Serializable> extends ImmutableAbstract<T> {
    public Immutable(Collection<? extends T> coll){
        super.dataList.addAll(coll);
    }
    
    @Override
    public boolean add(T e) {
        throw new IllegalArgumentException("The list is immutable - you cannot add element!");
    }
    
    @Override
    public T get(int index) {
        T element = super.dataList.get(index);
        return SerializationUtils.clone(element);
    }
    
    @SafeVarargs
    public static <T extends Serializable> List<T> asList(T... arguments){
        return new Immutable<T>(Arrays.asList(arguments));
    }
}
