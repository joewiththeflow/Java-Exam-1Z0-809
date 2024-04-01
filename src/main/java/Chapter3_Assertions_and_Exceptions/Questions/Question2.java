package Chapter3_Assertions_and_Exceptions.Questions;

public class Question2 {
    public static void main(String[] args) {
        int j = 7;
        assert(++j > 7);
        assert(++j > 8): "hi";
        assert(j > 10): j=12;
//        assert(j == 12): doStuff();
        assert(j == 12): new Question2();
    }
    static void doStuff() {}
}

//Which are true?

// A. Compilation succeeds
// B. Compilation fails due to an error on line 6
// C. Compilation fails due to an error on line 7
// D. Compilation fails due to an error on line 8
// E. Compilation fails due to an error on line 9       --> CORRECT
// F. Compilation fails due to an error on line 10
