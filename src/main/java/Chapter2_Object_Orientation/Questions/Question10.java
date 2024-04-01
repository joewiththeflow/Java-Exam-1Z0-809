package Chapter2_Object_Orientation.Questions;

public class Question10 extends Singer {
    public static String sing() { return "fa"; }
    public static void main(String[] args) {
        Question10 t = new Question10();
        Singer s = new Question10();
        System.out.println(t.sing() + " " + s.sing());
    }
}
class Singer {
    public static String sing() {return "la";}
}

//What is the result?

// A. fa fa
// B. fa la         --> CORRECT
// C. la la
// D. Compilation fails
// E. AAn exception is thrown at runtime