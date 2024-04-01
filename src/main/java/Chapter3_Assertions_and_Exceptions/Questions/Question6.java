package Chapter3_Assertions_and_Exceptions.Questions;

public class Question6 {
    static String s = "-";
    class Whistle implements AutoCloseable {
        public void toot() { s+="t"; }
        public void close() { s+="c"; }
    }

    public static void main(String[] args) {
        new Question6().run();
        System.out.println(s);
    }
    public void run() {
        try (Whistle w = new Whistle()) {
            w.toot();
            s+="1";
            throw new Exception();
        } catch (Exception e) { s+="2"; }
        finally { s += "3"; }
    }
}

// What is the result?

// A. -t123t
// B. -t12c3
// C. -t123
// D. -t1c3
// E. -t1c23        --> CORRECT
// F. None of the above; main() throws an exception
// G. Compilation fails