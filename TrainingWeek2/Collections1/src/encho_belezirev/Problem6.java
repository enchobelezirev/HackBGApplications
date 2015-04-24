package encho_belezirev;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.RowFilter.Entry;

public class Problem6 {
    static <T> Set<T> duplicate(Set<T>... sets) {
        Set<T> returnSet = new HashSet<T>();
        Map<T, Integer> map = new HashMap<>();
        for (int i = 0; i < sets.length; i++) {
            List<T> itemsInSet = new ArrayList<>(sets[i]);
            for (T element : itemsInSet) {
                if (map.containsKey(element)) {
                    map.put(element, map.get(element)+1);
                }
                else{
                    map.put(element, 1);
                }
            }
        }
        Iterator it = map.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry pair = (Map.Entry)it.next();
            if ((int)pair.getValue() == sets.length) {
                returnSet.add((T)pair.getKey());
            }
        }
        return returnSet;
    }
}
