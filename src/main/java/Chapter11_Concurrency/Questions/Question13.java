package Chapter11_Concurrency.Questions;

public class Question13 {

//    Which are true? (Choose all that apply)

//    A. A Runnable may return a result but must not throw an Exception
//    B. A Runnable must not return a result nor throw an Exception             --> CORRECT
//    C. A Runnable must not return a result but may throw an Exception
//    D. A Runnable may return a result and throw an Exception
//    E. A Callable may return a result but must not throw an Exception
//    F. A Callable must not return a result nor throw an Exception
//    G. A Callable must not return a result but may throw an Exception
//    H. A Callable may return a result and throw an Exception                  --> CORRECT
}


// B and H are correct. Runnable and Callable serve similar purposes. Runnable has been available in Java since version 1.
// Callable was introduced in Java 5 and serves as a more flexible alternative to Runnable. A Callable allows a generic
// return type and permits thrown exceptions, whereas a Runnable does not.