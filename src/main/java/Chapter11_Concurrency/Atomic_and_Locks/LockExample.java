package Chapter11_Concurrency.Atomic_and_Locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockExample {
    // you can create a Lock with .lock() or the tryLock() method
    // the tryLock() method will not block and continue on so you can use a loop with it (although there is a better way)

    // The example below shows that ReEntrantLock can be used instead of synchronized
    // Thread A attempts to access the Locks in one order while B does the reverse
    // If synchronized were used, this could lead to a deadlock but there is no such problem with ReEntrantLock

//     tbh it seems that the second thread in this example always fails to acquire both locks

    public static void main(String[] args) {
        Lock l1 = new ReentrantLock();
        Lock l2 = new ReentrantLock();

        lockThreadA lA = new lockThreadA(l1, l2);
        lockThreadB lB = new lockThreadB(l1, l2);
        lA.start();
        lB.start();
        try {
            lA.join();
            lB.join();
        } catch (InterruptedException e) {}
        System.out.println("end main thread");

    }
}

class lockThreadA extends Thread {
    Lock l1;
    Lock l2;
    public lockThreadA(Lock l1, Lock l2) {
        this.l1 = l1;
        this.l2 = l2;
    }
    @Override
    public void run() {
        for(int i = 0; i < 20; i++) {
            boolean aq1 = l1.tryLock();
            boolean aq2 = l2.tryLock();
            try {
                if (aq1 && aq2) {
                    System.out.println("Both locks acquired by " + Thread.currentThread().getId() + " " + i);
                } else System.out.println("Failed to acquire both locks " + Thread.currentThread().getId() + " " + i);
                Thread.sleep(((long) Math.random()));
            } catch(InterruptedException e) {
            } finally {
                if (aq2) l2.unlock();    // only unlock if locked
                if (aq1) l1.unlock();
            }
        }
    }
}

class lockThreadB extends Thread {
    Lock l1;
    Lock l2;
    public lockThreadB(Lock l1, Lock l2) {
        this.l1 = l1;
        this.l2 = l2;
    }
    @Override
    public void run() {
        for(int i = 0; i < 20; i++) {
            boolean aq2 = l2.tryLock();
            boolean aq1 = l1.tryLock();
            try {
                if (aq1 && aq2) {
                    System.out.println("Both locks acquired by " + Thread.currentThread().getId());
                }
                else System.out.println("Failed to acquire both locks " + Thread.currentThread().getId() + " " + i);
                Thread.sleep((long) Math.random());
            } catch(InterruptedException e) {
            } finally {
                if (aq1) l1.unlock();    // only unlock if locked
                if (aq2) l2.unlock();
            }
        }
    }
}
