package encho_belezirev;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Problem6 {
    static <T> T duplicate(Set<T>... sets){
        T duplicateElement = null;
        boolean equal = false;
        for (int i = 1; i < sets.length; i++) {
            List<T> itemsInSet = new ArrayList<>(sets[i]); 
            List<T> itemsInPrevSet = new ArrayList<>(sets[i-1]);
            for (T elementNext : itemsInSet) {
                if (itemsInPrevSet.contains(elementNext)) {
                    equal = true;
                    duplicateElement = elementNext;
                }
            }
        }
        if (duplicateElement == null) {
            System.out.println("No duplicationg elements!");
            return null;
        }
        return duplicateElement;
    }
}
