package Chapter7_Inner_Classes.Qs;

public class Question4 {
    public static void main (String[] args) {
        Object o = new Object() {
            public boolean equals(Object obj) {
                return true;
            }
//        }    // Will fail because there needs to be a ";" at the end here
        };      // added in the correct closing brace and semi-colon
        System.out.println(o.equals("Fred"));
    }
}

// What is the result?

// A. An exception occurs at runtime
// B. true
// C. Fred
// D. Compilation fails because of an error on line 5
// E. Compilation fails because of an error on line 6
// F. Compilation fails because of an error on line 11
// G. Compilation fails because of an error on a line other than 5, 6, or 11        --> CORRECT - need ";" on line 9
