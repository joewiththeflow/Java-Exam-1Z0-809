package Chapter7_Inner_Classes.Qs;

import java.util.*;

public class Question13 {
    public static void main(String[] args) {
        String[] sa = {"nickel", "button", "key", "lint"};
        for (String s2 : sa) System.out.print(s2 + " ");
        Arrays.sort(sa, (a, b) -> a.compareTo(b));
        System.out.println();
        for (String s2 : sa) System.out.print(s2 + " ");
    }
}

// What is the result?

// A. Compilation fails
// B. button key lint nickel
//      nickel lint key button
// C. nickel button key lint                --> CORRECT
//      button key lint nickel
// D. nickel button key lint
//      nickel button key lint
// E. nickel button key lint
//      nickel lint key button
// F. An exception is thrown at runtime