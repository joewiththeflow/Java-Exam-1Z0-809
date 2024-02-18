package Chapter6_Generics_and_Collections.Using_Collections;

import java.util.TreeSet;

public class NavigableSetExample {
    public static void main(String[] args) {
        TreeSet<Integer> times = new TreeSet<>();
        times.add(1205);
        times.add(1505);
        times.add(1545);
        times.add(1830);
        times.add(2010);
        times.add(2100);

        System.out.println("times: " + times);

        // Java 5 version

        TreeSet<Integer> subset = new TreeSet<>();
        subset = (TreeSet<Integer>) times.headSet(1600);
        System.out.println("J5 - the last before 4pm is: " + subset.last());

        TreeSet<Integer> subset2 = new TreeSet<>();
        subset2 = (TreeSet<Integer>) times.tailSet(2000);
        System.out.println("J5 - the first after 8pm is: " + subset2.first());


        // Java 6 version using new lower() and higher() methods
        System.out.println("J6 - the last before 4pm is: " + times.lower(1600));
        System.out.println("J6 - the first after 8pm is: " + times.higher(2000));

        // floor() gives the first element that is equal or lower
        System.out.println("J6 - the first before or equal to 3.45pm is: " + times.floor(1545));

        // ceiling() gives the first element that is equal or higher
        System.out.println("J6 - the first after or equal to 2010 is: " + times.ceiling(2010));

        // Out of curiosity, if there is no matching value, you get null back
        System.out.println("J6 - the last before 12.05pm is: " + times.lower(1205));    // null

        // pollFirst () and pollLast() methods
        System.out.println("Poll first entry: " + times.pollFirst());   // removes and returns Integer 1205
        System.out.println("times: " + times);
        System.out.println("Poll last entry: " + times.pollLast());     // removes and returns Integer 2100
        System.out.println("times: " + times);

        // descendingSet() to return a reversed Set - doesn't reverse in place
        System.out.println("reversed times" + times.descendingSet());
        System.out.println("times: " + times);

        // There are similar methods for NavigableMap:
        // lowerKey()
        // higherKey()
        // floorKey()
        // ceilingKey
        // pollFirstEntry()
        // pollLastEntry()
        // descendingMap()


    }
}
