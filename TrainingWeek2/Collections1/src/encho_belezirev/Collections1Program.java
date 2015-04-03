package encho_belezirev;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

public class Collections1Program {

    public static void main(String[] args) {
        // System.out.println(Problem0.isExpressionValid("(()()()()())"));
        // Collection<Integer> test = new ArrayList<Integer>();
        // test.add(1);
        // test.add(3);
        // test.add(5);
        // test.add(9);
        //
        // test.add(10);
        // test.add(20);
        // Problem1.reverse(test);
        // System.out.println(test.toString());
        // Problem2<Integer> ints = new Problem2<Integer>();
        // ints.addAll(test);
        // for (int i = 0; i < ints.size(); i++) {
        // System.out.println(ints.getElement(i));
        // }

         Problem3<Integer> ints = new Problem3<Integer>(3);
         ints.offer(1);
         ints.offer(2);
         ints.offer(3);
         ints.offer(4);
         ints.offer(5);
        
         ints.offer(6);
         ints.offer(7);
         ints.offer(8);
        
         ints.offer(9);
         ints.offer(10);
         ints.offer(11);
         System.out.println(ints.toString());

        // Collection<String> ints = new ArrayList<String>();
        // ints.add("one");
        // ints.add("two");
        // ints.add("dsad");
        // ints.add("d");
        // ints.add("tsadawo");
        // ints.add("tffwo");
        // ints.add("a");
        // Problem4.rotate(ints, -2);
        // System.out.println(ints.toString());
        //
        // Collection<Integer> ints = Arrays.asList(1,2,3,4,5,5,4,3,1,1,1,2);
        // System.out.println(Problem5.firstUnique(ints)); //2;
        // //
        // //
        // Set<Integer> set = new HashSet<Integer>();
        // List<Problem7StudentClass> studentsList = new
        // ArrayList<Problem7StudentClass>();
        // studentsList.add(new Problem7StudentClass("encho", 6));
        // studentsList.add(new Problem7StudentClass("stamat", 5));
        // studentsList.add(new Problem7StudentClass("pesho", 3));
        // studentsList.add(new Problem7StudentClass("gosho", 2));
        // studentsList.add(new Problem7StudentClass("dragan", 4));
        //
        // studentsList.add(new Problem7StudentClass("angel", 6));
        // Collections.sort(studentsList, new Problem7Comparator());
        // for (Problem7StudentClass student : studentsList) {
        // System.out.println(student.getName());
        // }

        // Problem8 ints = new Problem8();
        // ints.add(13);
        // ints.add(13);
        // ints.add(13);
        // ints.add(13);
        // ints.add(14);
        // ints.add(14);
        // ints.add(16);
        // ints.add(18);
        // ints.add(21);
        // System.out.println(ints.getRange());
        // for (int element : ints) {
        // System.out.println(element);
        // }
        // HashMap<Integer, String> map = new HashMap<>();
        // map.put(1, "encho");
        // map.put(3, "gosho");
        // map.put(4, "pesho");
        // map.put(5, "stancho");
        // map.put(6, "ivan");
        // map.put(7, "stamat");
        // //System.out.println(Problem10.readableHashMap(map));
        //
        // Map<String, Integer> mapOcc =
        // Problem10.countOccurances("Ninjas are all over the place! We are all going to die!");
        // System.out.println(Problem10.readableHashMap(mapOcc));

//        Set<Integer> A = new HashSet<>();
//        A.add(1);
//        A.add(2);
//        A.add(3);
//        A.add(4);
//        A.add(5);
//        A.add(6);
//        Set<Integer> B = new HashSet<>();
//        B.add(4);
//        B.add(5);
//        B.add(9);
//        B.add(10);
//        Set<Integer> C = new HashSet<>();
//        C.add(5);
//        C.add(100);
//        C.add(200);
//        C.add(300);
//        
//        
//        System.out.println(Problem6.duplicate(A,B,C));
    }

}
