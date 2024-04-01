package Chapter3_Assertions_and_Exceptions.Questions;

import java.io.IOException;

public class Question10 {
    class Lamb implements AutoCloseable {
        public void close() {
            throw new RuntimeException("a");
        }


    }
    public static void main(String[] args) throws IOException {
        new Question10().run();
    }
    public void run() throws IOException {
        try (Lamb l = new Lamb();) {
            throw new IOException();
        } catch (Exception e) {
            throw e;
        }
    }
}

// Which exceptions will the code throw?

// A. IOException with suppressed RuntimeException a    --> CORRECT
// B. IOException with suppressed Exception e
// C. RuntimeException a with no suppressed exception
// D. Exception e with no suppressed exception
// E. RuntimeException a with suppressed Exception e
// F. RuntimeException c with suppressed RuntimeException a
// G. Compilation fails
