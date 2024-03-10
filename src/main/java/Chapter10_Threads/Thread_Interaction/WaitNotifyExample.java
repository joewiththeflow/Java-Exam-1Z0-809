package Chapter10_Threads.Thread_Interaction;

public class WaitNotifyExample {
    public static void main(String[] args) {
        ThreadB b = new ThreadB();
        b.start();

        synchronized(b) {
            try {
                System.out.println("Waiting for b to complete...");
                b.wait();
                // The thread releases the lock on b and waits
                // To continue, the thread needs the lock, so it may be blocked until it gets it
            } catch (InterruptedException e) {}
            System.out.println("Total is: " + b.total);
        }
    }
}

class ThreadB extends Thread {
    int total;

    @Override
    public void run() {
        synchronized(this) {
            for (int i = 0; i < 100; i++) {
                total += i;
            }
            notify();       // notify a single thread waiting on this object
        }
    }
}