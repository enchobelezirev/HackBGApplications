package encho_belezirev;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Problem5 {
    static int firstUnique(Collection<Integer> list){
        List<Integer> listCollection =  new ArrayList<Integer>(list);
        List<Integer> listPassedDigits = new ArrayList<Integer>();
        for (int i = 0; i < listCollection.size(); i++) {
            int lastIndexOfElement = listCollection.lastIndexOf(listCollection.get(i));
            if (lastIndexOfElement == i && !listPassedDigits.contains(listCollection.get(i))) {
                return listCollection.get(i);
            }
            listPassedDigits.add(listCollection.get(i));
        }
        
        return 0;
    }
}
