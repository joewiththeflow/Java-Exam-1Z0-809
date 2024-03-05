package Chapter10_Threads.Defining_Starting_Threads;

public class MutlipleThreadsExample {
    public static void main(String[] args) {
        NameRunnable nr = new NameRunnable();
        Thread t = new Thread(nr);

        t.setName("Fred");      // set the Thread's name
        t.start();

        // Even if you don't give a Thread a name it still has one:
        Thread t2 = new Thread(nr);
        t2.start();         // Produces: Run by Thread-1

        // You can even print out the name of the main() Thread:
        System.out.println("Thread is " + Thread.currentThread().getName());    // Thread is main
    }
}

class NameRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("NameRunnable running");
        System.out.println("Run by " + Thread.currentThread().getName());   // gets name of current Thread
    }
}


