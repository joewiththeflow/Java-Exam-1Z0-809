package Chapter7_Inner_Classes.Qs;

public class Question11 {
    private int size = 7;
    private static int length = 3;

    public static void main(String[] args) {
        new Question11().go();
    }

    void go() {
        int size = 5;

        System.out.println(new Gazer().adder());        // the size in the method is not relevant as it is not passed in
    }

    class Gazer {
        int adder() { return size * length; }
    }
}

// What is the result?

// A. 15
// B. 21                                                        --> CORRECT
// C. An exception is thrown at runtime
// D. Compilation fails due to multiple errors
// E. Compilation fails due only due to an error on line 4
// F. Compilation fails due only due to an error on line 5