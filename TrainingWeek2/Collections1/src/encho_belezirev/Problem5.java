package encho_belezirev;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Problem5 {
    static int firstUnique(Collection<Integer> list){
        List<Integer> listCollection =  new ArrayList<Integer>(list);
        Map<Integer,Integer> mapDigitsCount = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            if (mapDigitsCount.containsKey(listCollection.get(i))) {
                mapDigitsCount.put(listCollection.get(i), mapDigitsCount.get(listCollection.get(i))+1);
            }
            else{
                mapDigitsCount.put(listCollection.get(i),1);
            }
        }
        Iterator it = mapDigitsCount.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry pair = (Map.Entry)it.next();
            if ((int)pair.getValue() == 1) {
                return (int)pair.getKey();
            }
        }
        return 0;
    }
}
