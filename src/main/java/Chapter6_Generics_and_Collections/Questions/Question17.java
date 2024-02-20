package Chapter6_Generics_and_Collections.Questions;

import sun.security.x509.OtherName;

import java.util.Arrays;
import java.util.Comparator;

public class Question17 {
    public static void main(String[] args) {
        String[] s = {"map", "pen", "marble", "key"};
        Othello o = new Othello();
        Arrays.sort(s, o);
        for(String s2: s) System.out.print(s2 + " " );
        System.out.println(Arrays.binarySearch(s, "map"));
    }
    static class Othello implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            return o2.compareTo(o1);
        }
    }
}

// Which are true?

// A. Compilation fails
// B. The output will contain a 1
// C. The output will contain a 2
// D. The output will contain a -1                          --> CORRECT, the comparator has not been passed into binarySearch
                                                            // therefore assumption is natural sort order, so when it finds
                                                            // "pen" as first item, it assumes "map should be inserted here
                                                            // Returned value is insertion point -1, so 0 - 1 = -1
// E. An exception is thrown at runtime
// F. The output will contain "key map marble pen"
// G. The output will contain "pen marble map key"          --> CORRECT
