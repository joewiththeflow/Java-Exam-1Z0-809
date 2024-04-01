package Chapter2_Object_Orientation.Questions;

class Mammal {
    String name = "furry ";
    String makeNoise() { return "generic noise"; }
}
class Zebra extends Mammal {
    String name = "stripes ";
    String makeNoise() {return "bray";}
}
public class Question13 {
    public static void main(String[] args) {
        new Question13().go();
    }
    void go() {
        Mammal m = new Zebra();
        System.out.println(m.name + m.makeNoise());
    }
}

// What is the result?

// A. furry bray        --> CORRECT
// B. stripes bray
// C. furry generic noise
// D. stripes generic noise
// E. Compilation fails
// F. An exception is thrown at runtime