package Chapter7_Inner_Classes.Qs;

public class Question10 {
    class Manhattan {
        void doStuff() throws Exception {
            System.out.println("x ");
        }
    }
    class TimesSquare extends Manhattan {
        void doStuff() throws Exception {}          // uses this one so no output
    }

    public static void main(String[] args) throws Exception {
        new Question10().go();
    }

    void go() throws Exception { new TimesSquare().doStuff();}
}

// What is the result?

// A. x
// B. xx
// C. No output is produced                                     --> CORRECT
// D. Compilation fails due to multiple errors
// D. Compilation fails due only to an error on line 4
// D. Compilation fails due only due to an error on line 9
// D. Compilation fails due only ue to an error on line 13
// D. Compilation fails due only due to an error on line 17