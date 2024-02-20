package Chapter6_Generics_and_Collections.Questions;

import java.util.TreeSet;

public class Question13 {
    public static void main(String[] args) {
        TreeSet<String> s = new TreeSet<>();
        TreeSet<String> subs = new TreeSet<>();
        s.add("a"); s.add("b"); s.add("c"); s.add("d"); s.add("e");

        subs = (TreeSet)s.subSet("b", true, "d", true);
        s.add("g");
        s.pollFirst();
        s.pollFirst();
        s.add("c2");
        System.out.println(s.size() + " " + subs.size());
    }
}

// Which are true? (Choose all that apply)

// A. The size of s is 4
// B. The size of s is 5        --> CORRECT
// C. The size of s is 7
// D. The size of subs is 1
// E. The size of subs is 2
// F. The size of subs is 3     --> CORRECT
// G. The size of subs is 4
// H. An exception is thrown at runtime
