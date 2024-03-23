package Chapter11_Concurrency.Questions;

public class Question8 {

//    Given

//    AtomicInteger i = new AtomicInteger();

//    Which atomically increment i by 9? (Choose all that apply)

//    A. i.addAndGet(9);            --> CORRECT
//    B. i.getAndAdd(9);            --> CORRECT
//    C. i.set(i.get() + 9);
//    D. i.atomicIncrement(9);
//    E. i = i + 9;
}

// A and B are correct. The addAndGet and getAndAdd both increment the value stored in an AtomicInteger.
//
//Images Answer C is not atomic because in between the call to get and set, the value stored by i may have changed.
// Answer D is invalid because the atomicIncrement method is fictional, and answer E is invalid because auto-boxing
// is not supported for the atomic classes. The difference between the addAndGet and getAndAdd methods is that the first
// is a prefix method (++x) and the second is a postfix method (x++). (Objective 10.3)