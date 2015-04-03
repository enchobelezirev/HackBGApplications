package encho_belezirev;

import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Queue;

public class Problem4 {
    private static <T> void reIndexToTheRight(List<T> list){
        T prevelement = list.get(0);
        
        T currentElement = null;
        
        for (int i = 1; i < list.size(); i++) {
            currentElement = list.get(i);
            list.set(i,prevelement);
            prevelement = list.get(i-1);
            if (prevelement == list.get(i-1)) {
                prevelement = currentElement;
            }
        }
    }
    public static <T> void rotate(Collection<T> collection, int rotateStep){
        List<T> listCollection = new ArrayList<T>(collection);
        if (rotateStep > 0) {
            for (int i = listCollection.size()-1; i >=listCollection.size() - rotateStep; i--) {
                 T element = listCollection.get(listCollection.size()-1);
                 reIndexToTheRight(listCollection);
                 listCollection.set(0, element);
            }
        }
        else{
            rotateStep = Math.abs(rotateStep);
            int times = 0;
            while(times < rotateStep){
                T element = listCollection.get(0);
                reIndexToTheLeft(listCollection);
                listCollection.set(listCollection.size()-1, element);
                times++;
            }
        }
        collection.clear();
        collection.addAll(listCollection);
        
    }
    private static <T> void reIndexToTheLeft(List<T> list) {
        T prevelement = list.get(list.size()-1);
        
        T currentElement = null;
        
        for (int i = list.size()-2; i >=0; i--) {
            currentElement = list.get(i);
            list.set(i,prevelement);
            prevelement = list.get(i+1);
            if (prevelement == list.get(i+1)) {
                prevelement = currentElement;
            }
        }
    }
}
