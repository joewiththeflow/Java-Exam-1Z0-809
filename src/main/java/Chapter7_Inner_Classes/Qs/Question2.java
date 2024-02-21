package Chapter7_Inner_Classes.Qs;

public class Question2 {

}

class Boo {
    Boo(String s) {}
    Boo() {}
}

class Bar extends Boo {
    Bar() {}
    Bar(String s) {super(s);}
    void zoo() {
//        INSERT CODE HERE

    }
}

// Which statements create an anonymous inner class from within class Bar? (Choose all that apply)

// A. Boo f = new Boo(24) { };              // if this was a String it could create an inner class instance
// B. Boo f = new Bar() { };                --> CORRECT
// C. Boo f = new Boo() { String s; };      --> CORRECT
// D. Bar f = new Boo(String s) { };
// E. Boo f = new Boo.Bar(String s) { };

