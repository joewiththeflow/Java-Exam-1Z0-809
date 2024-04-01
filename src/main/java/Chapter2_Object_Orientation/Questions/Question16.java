package Chapter2_Object_Orientation.Questions;

interface MyInterface {
    default int doStuff() {
        return 42;
    }
}
public class Question16 implements MyInterface {
    public static void main(String[] args) {
        new Question16().go();
    }
    void go() {
        // INSERT CODE HERE
    }
    public int doStuff() {
        return 43;
    }
}

// Which lines inserted at // INSERT CODE HERE will allow the code to compile? (Choose all that apply)

// A. System.out.println("class: " + doStuff());                        --> CORRECT
// B. System.out.println("iface: " + super.doStuff());
// C. System.out.println("iface: " + MyInterface.super.doStuff());      --> CORRECT
// D. System.out.println("iface: " + MyInterface.doStuff());
// E. System.out.println("iface: " + super.MyInterface.doStuff());