package Chapter10_Threads.Defining_Starting_Threads;

public class ImplementRunnableExample implements Runnable {
    @Override
    public void run() {
        System.out.println("Important job running in ImplementRunnableExample");
    }

    // Bear in mind that Runnable is a functional interface, meaning we can also write a Runnable like this:

    // Runnable r = () -> System.out.println("Important job running in a Runnable");

    public static void main(String[] args) {

        // instantiate Runnable class
        ImplementRunnableExample r = new ImplementRunnableExample();

        // Need an instance of a Thread to run your Runnable job
        // If you create using the no-arg constructor, Thread will call its own run() method
        // The Runnable you pass is called the "target" Runnable
        Thread t = new Thread(r);       // pass your Runnable to the Thread

        // Or you could do the following:
        Thread t2 = new Thread(
                () -> System.out.println("Important job running in t2")
        );

        // Before starting, the Thread is said to be in a "new" state, not "alive"
        // Once start() is called, the Thread is considered "alive" even if the run() method hasn't actually started yet
        // Thread is considered "dead" when the run() method completes
        // The isAlive() method can check if the thread has been started but not yet finished its run() method yet

        // start the threads
        t.start();
        t2.start();

        // You can pass a single Runnable to multiple Thread objects, meaning several threads of execution will be
        // running the same job (and the same job will be done multiple times)
        Thread foo = new Thread(r);
        Thread bar = new Thread(r);
        Thread bat = new Thread(r);

        foo.start();
        bar.start();
        bat.start();

        // The Thread class itself implements Runnable
        // This means you can pass a Thread to another Thread's constructor:
        Thread t3 = new Thread(t);
        // This is silly but legal. A runnable is better as creating a whole other Thread is overkill
    }
}
