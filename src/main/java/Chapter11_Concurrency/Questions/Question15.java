package Chapter11_Concurrency.Questions;

public class Question15 {

//    When writing a RecursiveTask subclass, which are true? (Choose all that apply)

//    A. fork() and join() should be called on the same task        --> CORRECT
//    B. fork() and compute() should be called on the same task
//    C. compute() and join() should be called on the same task
//    D. compute() should be called before fork()
//    E. fork() should be called before compute()                   --> CORRECT
//    F. join() should be called after fork() but before compute()
}



// A and E are correct. When creating multiple ForkJoinTask instances, all tasks except one should be forked first, so
// they can be picked up by other Fork/Join worker threads. The final task should then be executed within the same thread
// (typically by calling compute()) before calling join() on all the forked tasks to await their results. In many cases,
// calling the methods in the wrong order will not result in any compiler errors, so care must be taken to call the
// methods in the correct order.