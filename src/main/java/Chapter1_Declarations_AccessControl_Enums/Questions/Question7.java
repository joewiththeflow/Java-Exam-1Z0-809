package Chapter1_Declarations_AccessControl_Enums.Questions;

public class Question7 extends Hobbit {
    public static void main(String[] args) {
        int myGold = 7;
//        System.out.println(countGold(myGold, 6));         // you need to recognise this is an attempt to access
                                                            // a method from a static context
    }
}

class Hobbit {
    int countGold(int x, int y) { return x + y; }
}

// What is the result?

// A. 13
// B. Compilation fails due to multiple errors
// C. Compilation fails due to an error on line 5
// D. Compilation fails due to an error on line 6       --> CORRECT
// E. Compilation fails due to an error on line 12

