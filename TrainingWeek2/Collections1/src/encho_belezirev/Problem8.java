package encho_belezirev;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Problem8 implements Statistics<Integer>, Iterable<Integer> {

    private List<Integer> data;
    
    public Problem8() {
        this.data = new ArrayList<Integer>();
    }

    public void add(int element) {
        this.data.add(element);
    }

    @Override
    public int getMean() {
        int sum = 0;
        for (int i = 0; i < data.size(); i++) {
            sum += data.get(i);
        }
        
        return sum/data.size();
    }

    @Override
    public int getMedian() {
        Collections.sort(data);
        int indexMiddle = (int) Math.ceil((data.size()-1)/2);
        return data.get(indexMiddle);
    }

    @Override
    public int getMode() {
        Collections.sort(data);
        int mode = 0;
        int maxCount = 0;
        int[] countElements = new int[data.get(data.size()-1)+1];
        for (int i = 0; i < data.size(); i++) {
            countElements[data.get(i)]++;
            if (maxCount < countElements[data.get(i)]) {
                maxCount = countElements[data.get(i)];
                mode = data.get(i);
            }
        }
        return mode;
    }

    @Override
    public int getRange() {
        return data.get(data.size()-1) - data.get(0);
    }

    @Override
    public Iterator<Integer> iterator() {
        return this.data.iterator();
    }

}
