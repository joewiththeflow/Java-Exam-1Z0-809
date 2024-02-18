package Chapter6_Generics_and_Collections.Using_Collections;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetExample {
    public static void main(String[] args) {
        boolean[] ba = new boolean[5];
        Set s = new HashSet();      // HashSets do not guarantee any ordering

//        Set s = new TreeSet();    // If we use TreeSet here, there will be an error
                                    // This is because the set cannot be sorted because the elements are not mutually
                                    // comparable - unless otherwise specified, objects of different types are not mutually
                                    // comparable

        ba[0] = s.add("a");                         // true
        ba[1] = s.add(new Integer(42));       // true
        ba[2] = s.add("b");                         // true
        ba[3] = s.add("a");                         // false - duplicate element
        ba[4] = s.add(new Object());                // true

        for (int x=0; x < ba.length; x++) {
            System.out.print(ba[x] + " ");
        }
        System.out.println();
        for(Object o : s) {
            System.out.print(o + " ");      // order is not predictable
        }

        // It is much better to specify a type when declaring a Set
        // Then you can use TreeSet for a sorted Set if you wish

        boolean[] ba2 = new boolean[5];
        Set<String> s2 = new TreeSet<>();

        ba2[0] = s2.add("a");                            // true
        ba2[1] = s2.add("t");                            // true
        ba2[2] = s2.add("b");                            // true
        ba2[3] = s2.add("a");                            // false - duplicate element
        ba2[4] = s2.add("z");                            // true

        for (int x=0; x < ba2.length; x++) {
            System.out.print(ba2[x] + " ");
        }
        System.out.println();
        for(Object o : s2) {
            System.out.print(o + " ");      // order is not predictable
        }

    }
}
