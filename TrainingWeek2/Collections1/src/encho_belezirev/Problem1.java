package encho_belezirev;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Problem1 {
    static <T> void reverse(Collection<T> collection) {
        List<T> list = new ArrayList<T>(collection);
        T swapElement = null;
        for (int i = 0; i < list.size() / 2; i++) {
            swapElement = list.get(i);
            list.set(i, list.get(list.size() - i - 1));
            list.set(list.size() - i - 1, swapElement);
        }
        
        collection.clear();
        collection.addAll(list);
    }
}
