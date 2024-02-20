package Chapter6_Generics_and_Collections.Questions;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Question11 {
    public static void main(String[] args) {
        Object o = new Object();
        // insert code here

//        s.add("o");                 // commented 2x lines as this won't compile
//        s.add(o);
    }
}

// Consider these three fragments:

// I.   Set s = new HashSet();
// II.  TreeSet s = new TreeSet();
// III. LinkedHashSet s = new LinkedHashSet();

// When fragments I, II, or III are inserted independently at line 6, which are true? (Choose all that apply)

// A. Fragment I compiles                               --> CORRECT
// B. Fragment II compiles                              --> CORRECT
// C. Fragment III compiles                             --> CORRECT
// D. Fragment I executes without exception             --> CORRECT
// E. Fragment II executes without exception            --> Cannot compare Object and String at runtime
// F. Fragment III executes without exception           --> CORRECT



