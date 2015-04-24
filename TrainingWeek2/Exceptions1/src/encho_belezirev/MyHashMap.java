package encho_belezirev;

import java.util.HashMap;
//Problem 3
public class MyHashMap<K,V> extends HashMap<K,V>  {
    private boolean allowNull;
    
    public MyHashMap(boolean isAllowedNull) {
        super();
        allowNull = isAllowedNull;
    }
    
    public MyHashMap() {
        super();
        allowNull = false;
    }
    
    @Override
    public V put(K key, V value) {
        if (key == null && !this.allowNull) {
            throw new NullPointerException("The key for the HashMap cannot be null!");
        }
        return super.put(key, value);
    }
    
    @Override
    public V get(Object key) {
        if (!allowNull && key.equals(null)) {
            throw new NullPointerException("You are trying to access an object with null key - this is not allowed!");
        }
        return super.get(key);
    }
}
