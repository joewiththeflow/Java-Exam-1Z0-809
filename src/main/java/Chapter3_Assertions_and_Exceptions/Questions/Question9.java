package Chapter3_Assertions_and_Exceptions.Questions;

import java.io.Closeable;
import java.io.IOException;

public class Question9 {
    class Lamb implements Closeable {
        public void close() {
            throw new RuntimeException("a");
        }
    }

    public static void main(String[] args) {
        new Question9().run();
    }
    public void run() {
        try (Lamb l = new Lamb();) {
            throw new IOException();
        } catch(Exception e) {
            throw new RuntimeException("c");
        }
    }
}
// Which exceptions will the code throw?

// A. IOException with suppressed RuntimeException a
// B. IOException with suppressed RuntimeException c
// C. RuntimeException a with no suppressed exception
// D. RuntimeException c with no suppressed exception       --> CORRECT
// E. RuntimeException a with suppressed RuntimeException c
// F. RuntimeException c with suppressed RuntimeException a
// G. Compilation fails