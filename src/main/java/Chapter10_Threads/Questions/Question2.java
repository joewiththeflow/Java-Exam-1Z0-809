package Chapter10_Threads.Questions;

public class Question2 extends Thread {
    public static void main(String[] args) {
        Question2 t = new Question2();
        Thread x = new Thread(t);
        t.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; ++i) {
            System.out.println(i + "..");
        }
    }
}

// What is the result of running this code?

// A. Compilation fails
// B. 1..2..3
// C. 0..1..2..3
// D. 0..1..2                           --> CORRECT, passing a Thread to a Thread is legal but not recommended
// E. An exception occurs at runtime
