package Chapter3_Assertions_and_Exceptions.Questions;

public class Question7 {
    class Lamb implements AutoCloseable {
        public void close() throws Exception {
            System.out.print("l");
        }
    }
    class Goat implements AutoCloseable {
        public void close() throws Exception {
            System.out.print("g");
        }
    }

    public static void main(String[] args) throws Exception {
        new Question7().run();
    }
    public void run() throws Exception {
        try (Lamb l = new Lamb();
//            System.out.print("t");    // commented so that code compiles
            Goat g = new Goat();) {
            System.out.print("2");
        } finally {
            System.out.print("f");
        }
    }
}
//What is the result?

// A. 2glf
// B. 2lgf
// C. tglf
// D. t2lgf
// E. 2glf
// F. None of the above; main() throws an exception
// G. Compilation fails     --> CORRECT