package Chapter10_Threads.Questions;

public class Question6 {

    // Assume the following method is properly synchronized and called from thread A on an object B

    // wait(2000);

    // After calling this method, when will thread A become a condidate to get another turn at the CPU?

    // A. After object B is notified, or after 2 seconds            --> CORRECT
    // B. After the lock on object B is released, or after 2 seconds
    // C. Two seconds after object B is notified
    // D. Two seconds after lock B is released
}
