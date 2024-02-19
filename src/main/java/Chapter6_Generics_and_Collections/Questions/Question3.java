package Chapter6_Generics_and_Collections.Questions;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Question3 {
    public static void main(String[] args) {

//        before();
    }

    public static void before() {
        Set set = new TreeSet();
        set.add("2");
        set.add(3);
        set.add("1");
        Iterator it = set.iterator();
        while (it.hasNext())
            System.out.println(it.next() + " ");
    }
}

// Which statements are true?

// A. The before() method will print 1 2
// B. The before method() will print 1 2 3
// C. The before method() will print 3 numbers, but the order cannot be determined
// D. The before method() will not compile
// E. The before method() will throw and exception at runtime   --> CORRECT - line 16, TreeSet can't compare String with Integer
