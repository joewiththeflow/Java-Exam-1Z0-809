package Chapter2_Object_Orientation.Questions;

class Clidder {
    private final void flipper() {
        System.out.println("Clidder");
    }
}
public class Question3 extends Clidder {
    public final void flipper() {
        System.out.println(" Clidlet");
    }

    public static void main(String[] args) {
        new Question3().flipper();
    }
}

//What is the result?

// A. Clidlet               --> CORRECT
// B. Clidder
// C. Clidder
//    Clidlet
// D. Clidlet
//    Clidder
// E. Compilation fails