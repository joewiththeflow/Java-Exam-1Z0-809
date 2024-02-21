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

// What is the result?

// A. Compilation fails             --> CORRECT, you cannot create a new inner class from a static context!!!
// B. button key lint nickel
//        nickel lint key button
// C. nickel button key lint
//        button key lint nickel
// D. nickel button key lint
//        nickel button key lint
// E. nickel button key lint        --> Would have been if Sorter class was static
//        nickel lint key button
// F. An exception is thrown at runtime
