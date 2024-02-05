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
//        Boo f = new Boo(24) {};           // type int rather than String
        Boo f = new Bar() {};
        Boo g = new Boo() {String s;};
//        Bar h = new Boo(String s) {};     // Declaring a new String as an argument but it has't been defined
//        Boo i = new Boo.Bar(String s) {};   // Bar is not an inner class, new String arg s hasn't been defined either
    }
}

