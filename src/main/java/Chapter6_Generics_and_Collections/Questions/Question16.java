package Chapter6_Generics_and_Collections.Questions;

import java.util.TreeSet;

class Dog3 { int size; Dog3(int s) { size = s; }}
public class Question16 {
    public static void main(String[] args) {
        TreeSet<Integer> i = new TreeSet<>();
        TreeSet<Dog3> d = new TreeSet<>();

        d.add(new Dog3(1)); d.add(new Dog3(2)); d.add(new Dog3(1));
        i.add(1); i.add(2); i.add(1);
        System.out.print(d.size() + " " + i.size());

    }
}

// What is the result

// A. 1 2
// B. 2 2
// C. 2 3
// D. 3 2
// E. 3 3
// F. Compilation fails
// G. An exception is thrown at runtime         --> CORRECT, Dog3 has not implemented Comparable so TreeSet can't compare Dog3 instances