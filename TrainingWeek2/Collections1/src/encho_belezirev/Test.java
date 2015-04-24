package encho_belezirev;

import java.util.Collection;

public class Test<T> {
    
    public void test(Collection<? super T> collection){
        
    }
 
    public static void main(String[] args) {
        Test<Integer> instance = new Test<Integer>();
        Collection<Number> coll = null;
        instance.test(coll);
    }
}
