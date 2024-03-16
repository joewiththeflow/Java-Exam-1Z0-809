package Chapter10_Threads.Questions;

class Dudes {
    static long flag = 0;
    // insert code here
     void chat(long id) {            // II. put in so it compiles
        if (flag == 0) flag = id;           // first thread to hit will set flag to its id
        for (int x = 1; x < 3; x++) {
            if (flag == id) System.out.print("yo ");
            else System.out.print("dude ");
        }
    }
}
public class Question15 implements Runnable {
    static Dudes d;

    public static void main(String[] args) {
        new Question15().go();
    }
    void go() {
        d = new Dudes();
        new Thread(new Question15()).start();
        new Thread(new Question15()).start();
    }
    public void run() {
        d.chat(Thread.currentThread().getId());
    }
}

// And given these two fragments

// I. synchronized void chat(long id) {
// II. void chat(long id) {

// When fragment I. or II. is inserted at line 5, which are true? (Choose all that apply)

// A. An exception is thrown at runtime
// B. With fragment I, compilation fails
// C. With fragment II, compilation fails
// D. With fragment I, the output could be yo dude dude yo
// E. With fragment I, the output could be dude dude yo yo
// F. With fragment II, the output could be yo dude dude yo         --> CORRECT


// F is correct. With Fragment I, the chat method is synchronized, so the two threads can’t swap back and forth.
// With either fragment, the first output must be yo. -- Joe, this statement is not correct, for fragment I it could be
// dude dude yo yo - less likely but I proved it can happen on my machine
//
// A, B, C, D, and E are incorrect based on the above. (OCP Objective 10.3)