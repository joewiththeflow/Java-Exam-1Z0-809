package Chapter10_Threads.Questions;

class Chicks {
    synchronized void yack(long id) {
        for (int x = 1; x < 3; x++) {
            System.out.print(id + " ");
            Thread.yield();
        }
    }
}
public class Question16 implements Runnable {
    Chicks c;                                   // not static so will be null for the two created Threads

    public static void main(String[] args) {
        new Question16().go();
    }

    void go() {
        c = new Chicks();                       // the key part, go is not called on the two threads so is null
        new Thread(new Question16()).start();
        new Thread(new Question16()).start();
    }

    @Override
    public void run() {
        c.yack(Thread.currentThread().getId());     // will be null on threads as hasn't been initialised
    }
}

// Which are true? (Choose all that apply)

// A. Compilation fails
// B. The output could be 4 4 2 3
// C. The output could be 4 4 2 2
// D. The output could be 4 4 4 3
// E. The output could be 2 2 4 4
// F. An exception is thrown at runtime     --> CORRECT



// F is correct. When run() is invoked, it is with a new instance of ChicksYack and c has not been assigned to an object.
// If c were static, then because yack is synchronized, answers C and E would have been correct.
//
// A, B, C, D, and E are incorrect based on the above. (OCP Objectives 10.1 and 10.3)