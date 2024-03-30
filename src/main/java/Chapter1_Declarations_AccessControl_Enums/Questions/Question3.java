package Chapter1_Declarations_AccessControl_Enums.Questions;

enum Animals {
    DOG("woof"), CAT("meow"), FISH("burble");
    String sound;
    Animals(String s) {sound = s;}
}
public class Question3 {
    static Animals a;

    public static void main(String[] args) {
        System.out.println(a.DOG.sound + " " + a.FISH.sound);
    }
}

//What is the result?

// A. woof burble                       --> CORRECT
// B. Multiple compilation errors
// C. Compilation fails due to an error on line 4
// D. Compilation fails due to an error on line 5
// E. Compilation fails due to an error on line 6
// F. Compilation fails due to an error on line 12