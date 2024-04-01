package Chapter2_Object_Orientation.Questions;

class X { void do1() {}}
class Y extends X { void do2() {}}
public class Question6 {
    public static void main(String[] args) {

        X x1 = new X();
        X x2 = new Y();
        Y y1 = new Y();
        // INSERT CODE HERE
    }
}

// Which of the following inserted at //INSERT CODE HERE will compile? (Choose all that apply)

// A. x2.do2();
// B. (Y)x2.do2();
// C. ((Y)x2).do2();    --> CORRECT
// D. None of the above statements will compile
