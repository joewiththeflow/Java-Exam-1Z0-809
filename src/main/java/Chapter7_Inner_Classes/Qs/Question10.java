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
