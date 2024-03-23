package Chapter11_Concurrency.Questions;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Question10 {
    public static void main(String[] args) {
        ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
        rwl.readLock().unlock();
        System.out.println("READ-UNLOCK-1");
        rwl.readLock().lock();
        System.out.println("READ-LOCK-1");
        rwl.readLock().lock();
        System.out.println("READ-LOCK-2");
        rwl.readLock().unlock();
        System.out.println("READ-UNLOCK-2");
        rwl.writeLock().unlock();
        System.out.println("WRITE-LOCK-1");
        rwl.writeLock().unlock();
        System.out.println("WRITE-UNLOCK-1");
    }


}

//What is the result?

// A. The code will not compile
// B. The code will compile and output:
//        READ-UNLOCK-1
//        READ-LOCK-1
//        READ-LOCK-2
//        READ-UNLOCK-2
// C. The code will compile and output:
//        READ-UNLOCK-1
//        READ-LOCK-1
//        READ-LOCK-2
//        READ-UNLOCK-2
//        WRITE-LOCK-1
//        WRITE-UNLOCK-1
// D. A java.lang.IllegalMonitorStateException will be thrown       --> CORRECT

