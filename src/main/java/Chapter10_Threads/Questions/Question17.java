package Chapter10_Threads.Questions;

public class Question17 implements Runnable {

    public void run() {
        move(Thread.currentThread().getId());
    }

    // insert code here
    void move(long id) {            // Put in just now so code compiles
        System.out.print(id + " ");
        System.out.print(id + " ");
    }

    public static void main(String[] args) {
        Question16 ch = new Question16();
        new Thread(ch).start();
        new Thread(new Question16()).start();
    }
}

// Given these two fragments:

// I. synchronized void move(long id)
// II. void move(long id)

// When ether fragment is inserted at line 9, which are true? (Choose all that apply)

// A. Compilation fails
// B. With fragment I, an exception is thrown
// C. With fragment I, the output could be 4 2 4 2  --> CORRECT
// D. With fragment I, the output could be 4 4 2 3
// E. With fragment II, the output could be 2 4 2 4 --> CORRECT



// C and E are correct. E should be obvious. C is correct because, even though move() is synchronized, it’s being
// invoked on two different objects.
//
// A, B, and D are incorrect based on the above. (OCP Objective 10.3)
