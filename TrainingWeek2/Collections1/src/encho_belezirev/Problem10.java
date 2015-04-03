package encho_belezirev;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Problem10 {
    static Map<String, Integer> countOccurances(String text){
        Map<String, Integer> map = new HashMap<>();
        String[] split = text.split(" ");
        for (String word : split) {
            Integer occuranceCount = map.get(word);
            if (occuranceCount == null) {
                occuranceCount = 0;
            }
            map.put(word, occuranceCount+1);
            
        }
        return map;
    }
    static String readableHashMap(Map<? extends Object, ? extends Object> map){
        Set<?> keys = map.keySet();
        StringBuilder builder = new StringBuilder();
        builder.append("Key : Value\n");
        for (Object keyItem : keys) {
            Object value = map.get(keyItem);
            builder.append(keyItem.toString() +" : "+value.toString()+"\n");
        }
        return builder.toString();
    }
}
