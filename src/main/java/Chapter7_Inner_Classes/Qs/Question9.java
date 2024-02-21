package Chapter7_Inner_Classes.Qs;

public class Question9 {
    class Engine {
//        { Question9.drive(); }
//        { this.drive(); }
//        { Question9.this.drive(); }
//        { this.Question9.this.drive(); }
//        Engine() { Question9.drive();}
//        Engine() {this.drive();}
//        Engine() {Question9.this.drive();}
    }

    public static void main(String[] args) {
        new Question9().go();
    }

    void go() {
        new Engine();
    }

    void drive() {
        System.out.println("hi");
    }
}

// Which, inserted independently at line 5, produces the output "hi"? (Choose all that apply)

// A.       { Question9.drive(); }
// B.       { this.drive(); }
// C.       { Question9.this.drive(); }             --> CORRECT
// D.       { this.Question9.this.drive(); }
// E.       Engine() { Question9.drive();}
// F.       Engine() {this.drive();}
// G.       Engine() {Question9.this.drive();}      --> CORRECT - you're just accessing from with an Engine constructor