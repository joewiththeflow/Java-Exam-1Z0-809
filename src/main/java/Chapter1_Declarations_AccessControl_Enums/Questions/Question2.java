package Chapter1_Declarations_AccessControl_Enums.Questions;

class Rocket {
    private void blastOff() {
        System.out.print("bang ");
    }
}
public class Question2 extends Rocket {
    public static void main(String[] args) {
        new Question2().go();
    }
    void go() {
        blastOff();
        // Rocket.blastOff();   // Line A
    }
    private void blastOff() {
        System.out.print("sh-bang ");
    }
}

// Which are true?

// A. As the code stands, the output is bang
// B. As the code stands, the output is sh-bang                 --> CORRECT
// C. As the code stands, compilation fails
// D. If line A is uncommented, the output is bang-bang
// E. If line A is uncommented, the output is sh-bang bang
// F. If line A is uncommented, compilation fails               --> CORRECT
