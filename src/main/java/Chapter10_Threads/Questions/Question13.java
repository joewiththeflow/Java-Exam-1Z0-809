package Chapter10_Threads.Questions;

public class Question13 implements Runnable {

    void go(long id) {
        System.out.println(id);
    }

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getId() + " ");
        // Insert code here
    }
    @Override
    public void run() {
        go(Thread.currentThread().getId());
    }
}

// And given the following fragments:

// I. new Question13().run();
// II. new Question13().start();
// III. new Thread(new Question13());
// IV. new Thread(new Question13()).run();
// V. new Thread(new Question13()).start();

// When the five fragments are inserted, one at a time at line 9, which are true? (Choose all tha apply)

// A. All five will compile
// B. Only one might produce the output 4 4
// C. Only one might produce the output 4 2             --> CORRECT
// D. Exactly two might produce the output 4 4          --> CORRECT
// E. Exactly two might produce the output 4 2
// F. Exactly three might produce the output 4 4
// G. Exactly three might produce the output 4 2


// C and D are correct. Fragment I doesn’t start a new thread. Fragment II doesn’t compile. Fragment III creates a new
// thread but doesn’t start it. Fragment IV creates a new thread and invokes run() directly, but it doesn’t start the
// new thread. Fragment V creates and starts a new thread.
//
// A, B, E, F, and G are incorrect based on the above. (OCP Objective 10.1)