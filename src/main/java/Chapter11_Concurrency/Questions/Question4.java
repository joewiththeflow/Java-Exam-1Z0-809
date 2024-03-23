package Chapter11_Concurrency.Questions;

public class Question4 {

//    Given

//    ArrayBlockingQueue<Integer> abq = new ArrayBlockingQueue<>(10);

//    Which operations(s) can block indefinitely? (Choose all that apply)

//    A. abq.add(1);
//    B. abq.offer(1);
//    C. abq.put(1);                        --> CORRECT
//    D. abq.offer(1, 5, TimeUnit.SECONDS);

//    C is correct. The add method will throw an IllegalStateException if the queue is full. The two offer methods will
//    return false if the queue is full. Only the put method will block until space becomes available.
}