package Chapter2_Object_Orientation.Questions;

import java.sql.SQLOutput;

class Bird {
    {
        System.out.print("b1 ");
    }
    public Bird() {
        System.out.print("b2 ");
    }
//    static {                              // NOTE - if this static was here, this would be called before Raptor statics
//        System.out.print("top static");
//    }
}

class Raptor extends Bird {
    static {
        System.out.print("r1 ");
    }
    public Raptor() {
        System.out.print("r2 ");
    }
    {
        System.out.print("r3 ");
    }
    static {
        System.out.print("r4 ");
    }
}
public class Question5 extends Raptor {
    public static void main(String[] args) {
        System.out.print("pre ");
        new Question5();
        System.out.println("hawk ");
    }
}

// What is the result?

// A. pre b1 b2 r3 r2 hawk
// B. pre b2 b1 r2 r3 hawk
// C. pre b2 b1 r2 r3 hawk r1 r4
// D. r1 r4 pre b1 b2 r3 r2 hawk    --> CORRECT
// E. r1 r4 pre b2 b1 r2 r3 hawk
// F. pre r1 r4 b1 b2 r3 r2 hawk
// G. pre r1 r4 b2 b1 r2 r3 hawk
// H. The order of output cannot be predicted
// I. Compilation fails