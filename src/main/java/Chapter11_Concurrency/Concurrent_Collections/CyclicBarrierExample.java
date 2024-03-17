package Chapter11_Concurrency.Concurrent_Collections;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {
    List<String> result = new ArrayList<>();
    static String[] dogs1 = {"boi", "clover", "charis"};
    static String[] dogs2 = {"aiko", "zooey", "biscuit"};
    final CyclicBarrier barrier;    // The barrier for the threads
    // 4
    class ProcessDogs implements Runnable {
        String dogs[];
        ProcessDogs(String[] d) { dogs = d; }
        public void run() {
            for (int i = 0; i < dogs.length; i++) {
                String dogName = dogs[i];
                String newDogName = dogName.substring(0, 1).toUpperCase() + dogName.substring(1);
                dogs[i] = newDogName;
            }
            try {
                // 5
                barrier.await();        // wait at the barrier
            } catch (InterruptedException | BrokenBarrierException e) {
                // The other thread must have been interrupted
                e.printStackTrace();
            }
            // 7
            System.out.println(Thread.currentThread().getName() + " is done!");
        }
    }

    public CyclicBarrierExample() {
        // 1
        barrier = new CyclicBarrier(2, () -> {      // 2 threads, one runnable
            // 6
           for (int i = 0; i < dogs1.length; i++) {
               result.add(dogs1[i]);
           }
            for (int i = 0; i < dogs2.length; i++) {
                result.add(dogs2[i]);
            }
            System.out.println(Thread.currentThread().getName() + " Result: " + result);
        });
        // 2
        Thread t1 = new Thread(new ProcessDogs(dogs1));
        Thread t2 = new Thread(new ProcessDogs(dogs2));
        // 3
        t1.start();
        t2.start();
        System.out.println("Main thread is done");
    }

    public static void main(String[] args) {
        CyclicBarrierExample cb = new CyclicBarrierExample();
    }
}

//In this example, we have two arrays of dog names and the processing is quite simple; we just convert the first letter
// of each dog name from lowercase to uppercase. Once both arrays have been processed, we then combine the results into
// an ArrayList of dog names. In the class CB, we define the result ArrayList, where we’ll write results when both
// threads have finished processing the two arrays, dogs1 and dogs2. We also declare the CyclicBarrier that both threads
// will use to wait for each other. Let’s step through how the code executes (follow the numbers in the code):
//
//1.   In the CB constructor, we create a new CyclicBarrier, passing in the number of threads that will wait at the
// barrier and a Runnable that will be run by the last thread to reach the barrier. Here, we’re using a lambda
// expression for this Runnable.
//
//2.   We then create two threads, t1 and t2, and pass each the ProcessDogs Runnable. When we create the ProcessDogs
// Runnables for the threads, we pass in the array that the thread will process: we pass dogs1 to thread t1 and dogs2
// to thread t2.
//
//3.   We then start both threads and print a message saying the main thread is done.
//
//4.   The two threads begin running and process their respective arrays. The ProcessDogs run() method simply iterates
// through the array and converts the first letter of the dog name to uppercase, storing the modified string back in
// the original array.
//
//5.   Once the loop is complete, the thread then waits at the barrier by calling the barrier’s await() method. We’ll
// come back and talk about the exception handling in a minute.
//
//6.   Once both threads reach the barrier, then the Runnable we passed to the CyclicBarrier constructor is executed
// by the last thread to reach the barrier. This adds all the items from both arrays to the ArrayList result and
// prints the result.
//
//7.   When the Runnable completes, then both threads are released and can continue executing where they left off at
// the barrier. In this example, each thread just prints a message to the console indicating it’s done (with the thread
// name), but you can imagine that in a more realistic example, they could continue on to do more processing. Notice
// that neither thread can print out that it’s done until both threads have reached the barrier and the barrier
// Runnable is complete.
