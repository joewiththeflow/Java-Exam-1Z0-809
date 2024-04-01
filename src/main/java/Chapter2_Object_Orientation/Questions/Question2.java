package Chapter2_Object_Orientation.Questions;

class Top {
//    public Top(String s) {            // There's no default constructor here
//        System.out.print("B");
//    }
}
public class Question2 extends Top {
    public Question2(String s) {
        System.out.println("D");
    }

    public static void main(String[] args) {
        new Question2("C");
        System.out.println(" ");
    }
}

//What is the result?

// A. BD
// B. DB
// C. BDC
// D. DBC
// E. Compilation fails         --> CORRECT
