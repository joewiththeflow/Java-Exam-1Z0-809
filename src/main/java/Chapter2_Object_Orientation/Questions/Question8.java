package Chapter2_Object_Orientation.Questions;

class Dog {
    public void bark() {
        System.out.print("woof ");
    }
}
class Hound extends Dog {
    public void sniff() {
        System.out.print("sniff ");
    }
    public void bark() {
        System.out.print("howl ");
    }
}
public class Question8 {
    public static void main(String[] args) {
        new Question8().go();
    }
    void go() {
        new Hound().bark();
        ((Dog) new Hound()).bark();

//        ((Dog) new Hound()).sniff();  // commented so code will compile
    }
}

// What is the result?

// A. howl howl sniff
// B. howl woof sniff
// C. howl howl followed by an exception
// D. howl woof followed by an excpetion
// E. Compilation fails with error at line 22
// F. Compilation fails with error at line 24       --> CORRECT
