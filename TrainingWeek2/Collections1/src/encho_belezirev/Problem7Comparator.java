package encho_belezirev;

import java.util.Comparator;

public class Problem7Comparator implements Comparator<Problem7StudentClass> {

    @Override
    public int compare(Problem7StudentClass o1, Problem7StudentClass o2) {
        
        return o1.compareTo(o2);
    }

}
