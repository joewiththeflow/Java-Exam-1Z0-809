package Chapter10_Threads.Questions;

public class Question1 {
    public static void main(String[] args) {

        // The following block of code creates a Thread using a Runnable target:

        // Runnable target = new MyRunnable();
        // Thread myThread = new Thread(target);

        // Which of the following classes can be used to create the target so that the preceding code compiles correctly?

        // A. public class MyRunnable extends Runnable { public void run() {} }
        // B. public class MyRunnable extends Object { public void run() {}  }
        // C. public class MyRunnable implements Runnable { public void run() {} }        --> CORRECT
        // D. public class MyRunnable implements Runnable { void run() {} }
        // E. public class MyRunnable implements Runnable { public void start() {} }
    }
}
