package Chapter10_Threads.Questions;

public class Question11 {
    synchronized void a() { actBusy(); }
    static synchronized void b() { actBusy(); }
    static void actBusy() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {}
    }

    public static void main(String[] args) {
        final Question11 x = new Question11();
        final Question11 y = new Question11();
        Runnable runnable = () -> {
            int option = (int) (Math.random() * 4);
            switch(option) {
                case 0: x.a(); break;
                case 1: x.b(); break;
                case 2: y.a(); break;
                case 3: y.b(); break;
            }
        };
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        thread1.start();
        thread2.start();
    }
}

// If the code compiles, which of the following pairs of method invocations could NEVER be executing at the same time?
// (Choose all tha pply)

// A. x.a() in thread1, and x.a() in thread2
// B. x.a() in thread1, and x.b() in thread2
// C. x.a() in thread1, and y.a() in thread2
// D. x.a() in thread1, and y.b() in thread2
// E. x.b() in thread1, and x.a() in thread2
// F. x.b() in thread1, and x.b() in thread2
// G. x.b() in thread1, and y.a() in thread2
// H. x.b() in thread1, and y.b() in thread2
// I. Compilation fails due to an error in Runnable






//A, F, and H are correct. A is correct because when synchronized instance methods are called on the same instance,
// they block each other. F and H can’t happen because synchronized static methods in the same class block each other,
// regardless of which instance was used to call the methods. (An instance is not required to call static methods;
// only the class.)

// C, although incorrect, could happen because synchronized instance methods called on different instances do not block
// each other. B, D, E, and G are incorrect but also could all happen because instance methods and static methods lock
// on different objects and do not block each other. I is incorrect because the code compiles.
// (OCP Objectives 10.2 and 10.3)