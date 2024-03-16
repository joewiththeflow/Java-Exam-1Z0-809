package Chapter10_Threads.Questions;

public class Question14 implements Runnable {
    public static void main(String[] args) {
        Thread t = new Thread(new Question14());
        t.start();
        System.out.println("m1 ");
//        t.join();                             // throws InterruptedException so must be in a try/catch
        System.out.println("m2 ");
    }
    public void run() {
        System.out.println("r1 ");
        System.out.println("r2 ");
    }
}

// Which are true?

// A. Compilation fails                     --> CORRECT
// B. The output could be r1 r2 m1 m2
// B. The output could be r1 r2 m1 m2
// B. The output could be r1 r2 m1 m2
// B. The output could be r1 r2 m1 m2
// F. An exception is thrown at runtime

// A is correct. The join() must be placed in a try/catch block. If it were, answers B and D would be correct.
// The join() causes the main thread to pause and join the end of the other thread, meaning "m2" must come last.

// B, C, D, E, and F are incorrect based on the above. (OCP Objective 10.1)