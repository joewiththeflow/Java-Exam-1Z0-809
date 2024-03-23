package Chapter11_Concurrency.Questions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Question9 {
    private ReadWriteLock rwl = new ReentrantReadWriteLock();
    private List<Integer> highScores = new ArrayList<>();
    public void addScore(Integer score) {
        // Position A
        Lock lock = rwl.writeLock();     //--> just putting in so this compiles
        lock.lock();
        try {
            if (highScores.size() < 10) {
                highScores.add(score);
            } else if (highScores.get(highScores.size() - 1) < score) {
                highScores.set(highScores.size() - 1, score);
            } else {
                return;
            }
            Collections.sort(highScores, Collections.reverseOrder());
        } finally {
            lock.unlock();
        }
    }
    public List<Integer> getHighScores() {
        // Position B
        Lock lock = rwl.readLock();
        lock.lock();
        try {
            return Collections.unmodifiableList(new ArrayList<>(highScores));
        } finally {
            lock.unlock();
        }
    }
}

// Which block(s) of code best match the behaviour of the methods in the Question9 class? (Choose all that apply)

// A. Lock lock = rwl.reentrantLock(); // should be inserted at Position A
// B. Lock lock = rwl.reentrantLock(); // should be inserted at Position B
// C. Lock lock = rwl.readLock(); // should be inserted at Position A
// D. Lock lock = rwl.readLock(); // should be inserted at Position B       --> CORRECT
// E. Lock lock = rwl.writeLock(); // should be inserted at Position A      --> CORRECT
// F. Lock lock = rwl.writeLock(); // should be inserted at Position B

