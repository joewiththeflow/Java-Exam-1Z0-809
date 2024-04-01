package Chapter2_Object_Orientation.Questions;

interface FrogBoilable {
    static int getCtoF(int cTemp) {
        return (cTemp * 9 / 5) + 32;            // integer division (lose fractional part if it exists)
    }
    default String hop() { return "hopping "; }
}
public class Question14 implements FrogBoilable {
    public static void main(String[] args) {
        new Question14().go();
    }
    void go() {
        System.out.print(hop());
//        System.out.print(getCtoF(100));
        System.out.println(FrogBoilable.getCtoF(100));
        Question14 dbf = new Question14();
//        System.out.println(dbf.getCtoF(100));
    }
}

// What is the result?

// A. hopping 212
// B. Compilation fails due to an error on line 4
// C. Compilation fails due to an error on line 7
// D. Compilation fails due to an error on line 14
// E. Compilation fails due to an error on line 15      --> CORRECT
// F. Compilation fails due to an error on line 16
// G. Compilation fails due to an error on line 18      --> CORRECT