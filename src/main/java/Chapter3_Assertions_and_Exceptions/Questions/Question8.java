package Chapter3_Assertions_and_Exceptions.Questions;

public class Question8 {
//    class Lamb {
//        public void close() throws Exception {}
//    }
//
//    public static void main(String[] args) throws Exception {
//        new Question8().run();
//    }
//    public void run() throws Exception {
//        try (Lamb l = new Lamb();) {
//
//        }
//    }
}

// And the following changes:

// C1. Replace line 4 with class Lamb implements AutoCloseable {
// C2. Replace line 4 with class Lamb implements Closeable {
// C3. Replace line 14 with { finally {}

// What changes allow the code to compile?

// A. Just C1 is sufficient                 --> CORRECT
// B. Just C2 is sufficient
// C. Just C3 is sufficient
// D. Both C1 and C3 are required
// E. Both C2 and C3 are required
// F. The code compiles without any changes