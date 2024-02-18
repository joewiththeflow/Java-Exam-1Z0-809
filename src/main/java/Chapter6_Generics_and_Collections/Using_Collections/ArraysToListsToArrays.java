package Chapter6_Generics_and_Collections.Using_Collections;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ArraysToListsToArrays {
    public static void main(String[] args) {
        // Important to note that when you use Arrays.asList(), you return a FIXED-SIZE list backed by the array
        // This means that changes to the List of the array are reflected in each
        // HOWEVER, you cannot add or remove from the List

        String[] sa = {"one", "two", "three", "four"};
        List sList = Arrays.asList(sa);                         // make a List
        System.out.println("size " + sList.size());
        System.out.println("idx " + sList.get(2));

        sList.set(3, "six");                                    // change List
        sa[1] = "five";                                         // change Array
        for(String s : sa) {
            System.out.print(s + " ");
        }
        System.out.println("\nsa[1] " + sList.get(1));


        // x.toArray() can be used to make a new Object array
        // y = x.toArray(y) - x can be used to return an array T[] using y as the destination array
        List<Integer> iL = new ArrayList<Integer>();
        for(int x=0; x <3; x++) {
            iL.add(x);
        }
        Object[] oa = iL.toArray();         // create an Object array
        Integer[] ia2 = new Integer[3];     // create an Integer Array
        System.out.println("ia2 when created: ");
        for (Integer i : ia2) {
            System.out.print(i + " ");
        }
        ia2 = iL.toArray(ia2);
        System.out.println("\nia2 when used as the destination array, iL.toArray(ia2)");
        for (Integer i : ia2) {
            System.out.print(i + " ");
        }

    }

}
