package Chapter10_Threads.Questions;

public class Question7 {

    // Which are true?

    // A. The notifyAll() method must be called from a synchronized context         --> CORRECT
    // B. To call wait(), an object must own the lock on the thread                -- (thread must own the object lock)
    // C. The notify() method is defined in class java.lang.Thread
    // D. When a thread is waiting as a result of wait(), it releases its lock      --> CORRECT
    // E. The notify() method causes a thread to immediately release its lock
    // F. The difference between notify() and notifyAll() is that notifyAll() notifies all waiting threads,
    //    regardless of the object they're waiting on
}
