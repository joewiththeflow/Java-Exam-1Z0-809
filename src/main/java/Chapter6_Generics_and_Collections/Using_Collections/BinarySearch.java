package Chapter6_Generics_and_Collections.Using_Collections;

import java.util.Arrays;
import java.util.Comparator;

public class BinarySearch {
    public static void main(String[] args) {
        String [] sa = {"one", "two", "three", "four"};

        Arrays.sort(sa);            // sort alphabetically - the natural order
        for (String s : sa) {
            System.out.print(s + " ");
        }
        System.out.println("\none = " + Arrays.binarySearch(sa, "one"));    // search for "one" which is at index 1

        System.out.println("now reverse sort");
        ReSortComparator rs = new ReSortComparator();       // make a somparator instance
        Arrays.sort(sa,rs);                                 // resort the array using the Comparator
        for (String s : sa) {
            System.out.print(s + " ");
        }
        System.out.println("\none = " + Arrays.binarySearch(sa, "one"));    // get -1 here as we did not pass the comparator
                                                                                // meaning we're being told to insert "one" at index 0
                                                                                // The binary search thinks that you are searching based
                                                                                // on natural sort order, so when it looks at the current
                                                                                // item at index 0, "two", it doesn't bother looking at the
                                                                                // rest of the array and assumes that "one" comes before "two"
                                                                                // and should be inserted at index 0:
                                                                                    // the insertion point is the negative returned value + 1

        System.out.println("one = " + Arrays.binarySearch(sa, "one", rs));  // 2
                                                                                // finds the element "one" at index 2:
                                                                                // [two three one four]

    }

    static class ReSortComparator implements Comparator<String> {
        public int compare(String o1, String o2) {
            return o2.compareTo(o1);                // invert the sort
        }
    }
}

