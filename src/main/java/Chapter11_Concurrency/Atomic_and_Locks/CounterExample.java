package Chapter11_Concurrency.Atomic_and_Locks;

import java.util.concurrent.atomic.AtomicInteger;

class Counter {
    private int count;
    public void increment() {
        count++;        // a single "line is not atomic
    }
    public int getValue() {
        return count;
    }
}
class Counter2 {
    private AtomicInteger count = new AtomicInteger();
    public void increment() {
        count.getAndIncrement();    // atomic operation
    }
    public int getValue() {
        return count.intValue();
    }
}

class IncrementerThread extends Thread {
    private Counter counter;
    // all instances are passed the same counter
    public IncrementerThread(Counter counter) {
        this.counter = counter;
    }
    public void run() {
        // "i" is local and therefore thread-safe
        for(int i = 0; i < 10000; i++) {
            counter.increment();
        }
    }
}

class IncrementerThread2 extends Thread {
    private Counter2 counter;
    // all instances are passed the same counter
    public IncrementerThread2(Counter2 counter) {
        this.counter = counter;
    }
    public void run() {
        // "i" is local and therefore thread-safe
        for(int i = 0; i < 10000; i++) {
            counter.increment();
        }
    }
}
public class CounterExample {
    public static void main(String[] args) {
        Counter counter = new Counter();        // the shared object
        IncrementerThread it1 = new IncrementerThread(counter);
        IncrementerThread it2 = new IncrementerThread(counter);
        it1.start();
        it2.start();
        try {
            it1.join();     // Wait for thread 1 to finish
            it2.join();     // Wait for thread 2 to finish
        } catch (InterruptedException e) {
            System.out.println("interrupt");
        }
        System.out.println(counter.getValue());     // unlikely to be 20000

        Counter2 counter2 = new Counter2();        // the shared object
        IncrementerThread2 it3 = new IncrementerThread2(counter2);
        IncrementerThread2 it4 = new IncrementerThread2(counter2);
        it3.start();
        it4.start();
        try {
            it3.join();     // Wait for thread 3 to finish
            it4.join();     // Wait for thread 4 to finish
        } catch (InterruptedException e) {
            System.out.println("interrupt");
        }
        System.out.println(counter2.getValue());     // will be 20000
    }
}

