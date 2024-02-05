package Chapter7_Inner_Classes.Qs;

import java.sql.SQLOutput;
import java.util.*;

public class Question12 {
    public static void main(String[] args) {
        String[] sa = {"nickel", "button", "key", "lint"};
//        Sorter s = new Sorter();        // VERY IMPORTANT - cannot access from a static context
//        for (String s2 : sa) System.out.print(s2 + " ");
//        Arrays.sort(sa, s);
//        System.out.println();
//        for(String s2 : sa) System.out.print(s2 + " ");
    }
    class Sorter implements Comparator<String> {
        public int compare(String a, String b) {
            return b.compareTo(a);
        }
    }
}
