package Chapter11_Concurrency.Atomic_and_Locks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

// You can use the ReentrantReadWriteLock() which provies a readLock() and writeLock()
// You cannot hold both the readLock and writeLock at the same time
// Multiple threads can hold the readLock() at the same time
// One thread can hold the writeLock
public class ReadWriteLockExample {
    private List<Integer> integers = new ArrayList<>();
    private ReentrantReadWriteLock rw1 = new ReentrantReadWriteLock();

    public void add(Integer i) {
        rw1.writeLock().lock(); // one at a time
        try {
            integers.add(i);
        } finally {
            rw1.writeLock().unlock();
        }
    }

    public int findMax() {
        rw1.readLock().lock();  // many at once
        try {
            return Collections.max();
        } finally {
            rw1.readLock().unlock();
        }
    }
}
