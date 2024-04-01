package Chapter2_Object_Orientation.Questions;

class Alpha {
    static String s = " ";
    protected Alpha() { s += "alpha ";}
}
class SubAlpha extends Alpha {
    private SubAlpha() { s += "sub ";}
}
public class Question11 extends Alpha {
    private Question11() { s += "subsub ";}
    public static void main(String[] args) {
        new Question11();
        System.out.println(s);
    }
}

// What is the result?

// A. subsub
// B. sub subsub
// C. aplha subsub              --> CORRECT
// D. alpha sub subsub
// E. Compilation fails
// F. An exception is thrown at runtime