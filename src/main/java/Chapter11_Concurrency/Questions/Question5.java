package Chapter11_Concurrency.Questions;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Question5 {

    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(3, () -> {
            System.out.println(Singleton.INSTANCE.getValue());
        });
        Runnable r = () -> {
            for(int i = 0; i < 100; i++) {
                Singleton.INSTANCE.updateValue();
            }
            try {
                barrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        };
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        Thread t3 = new Thread(r);
        t1.start();
        t2.start();
        t3.start();
        System.out.println("Main thread is complete");
    }
}

// What do you expect the output to be and which thread(s) will be responsible for the output? (Choose al that apply)

// A. Main thread is complete
//    300
//    Main thread, thread t3
// B. 300
//    Main thread is complete
//    thread t3, Main thread
// C. Main thread is complete
//    300
// OR
//    Main thread is complete
//    300
//    Main thread, the last thread to reach the barrier
// D. The total value displayed could be any number because the Singleton is not thread-safe
//    Main thread is complete
//    Main thread, the last thread to reach the barrier
// E. Main thread is complete
//    A BrokenBarrierException
//    Main thread, thread t1

enum Singleton {
    INSTANCE;
    int value = 0;
    private void doSomethingWithValue() {
        value = value + 1;
    }

    public synchronized int updateValue() {
        doSomethingWithValue();
        return value;
    }

    public int getValue() {
        return value;
    }
}

// C is correct; you could see the output in either order because we don’t know in advance if threads t1, t2, and t3
// will complete before the main thread or if the main thread will complete first. However, in either case, t1, t2,
// and t3 will wait at the barrier until t1, t2, and t3 are all at the barrier, and the last thread to reach the barrier
// will display the output.
//
// A, B, D, and E are incorrect; A and B are incorrect because of the above. D is incorrect because the Singleton
// is thread-safe; enum singletons are guaranteed to be created in a thread-safe manner, and we have synchronized the
// updateValue() method. E is incorrect because it is highly unlikely one of these threads will get stuck or time out
// and none is accessing any collection that is not thread-safe. (OCP Objective 10.4)
