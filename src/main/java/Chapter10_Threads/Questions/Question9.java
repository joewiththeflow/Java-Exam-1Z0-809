package Chapter10_Threads.Questions;

public class Question9 {
    public static synchronized void main(String[] args) throws InterruptedException{
        Thread t = new Thread();
        t.start();
        System.out.println("X");
        t.wait(10000);
        System.out.println("Y");
    }
}

// A. It prints X and exits
// B. It prints X and never exits
// C. It prints XY and exits almost immediately
// D. It prints XY with a 10-second delay between X and Y
// E. It prints XY with a 10000 second delay between X and Y
// F. The code does not compile
// G. An exception is thrown at runtime         --> CORRECT

//The code does not acquire a lock on t before calling t.wait(), so it throws an IllegalMonitorStateException.
// The method is synchronized, but it’s not synchronized on t so the exception will be thrown.
// If the wait were placed inside a synchronized(t) block, then D would be correct.