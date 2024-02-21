package Chapter7_Inner_Classes.Qs;

class A { void m() {
    System.out.println("outer");
}}

public class Question8 {
    public static void main(String[] args) {
        new Question8().go();
    }

    void go() {
        new A().m();        // uses the inner class A. If inner A wasn't there, output would be "outer"
        class A {
            void m() {
                System.out.println("inner");
            }
        }
    }

    class A { void m() {
        System.out.println("middle");           // The output is middle
    }}
}

// What is the result?

// A. inner
// B. outer
// C. middle    --> CORRECT
// D. Compilation fails
// E. An exception is thrown at runtime