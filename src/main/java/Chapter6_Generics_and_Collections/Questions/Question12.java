package Chapter6_Generics_and_Collections.Questions;

import java.util.LinkedHashSet;

public class Question12 {
    public static void main(String[] args) {
        LinkedHashSet<Turtle> t = new LinkedHashSet<>();
        t.add(new Turtle(1)); t.add(new Turtle(2)); t.add(new Turtle(1));
        System.out.println(t.size());
    }
}

class Turtle {
    int size;
    public Turtle(int s) { size = s; }

    @Override
    public boolean equals(Object obj) {
        return ( this.size == ((Turtle)obj).size );
    }
    // insert code here
}

// Consider these two fragments

// I. public int hashCode() { return size/5; }
// II. // no hashCode method declared

// If fragment I or II is inserted independently at line 21, which are true? (Choose all that apply)

// A. If fragment I is inserted, the output is 2        --> CORRECT
// A. If fragment I is inserted, the output is 3
// A. If fragment II is inserted, the output is 2
// A. If fragment II is inserted, the output is 3       --> CORRECT
// A. If fragment I is inserted, compilation fails
// A. If fragment II is inserted, compilation fails
