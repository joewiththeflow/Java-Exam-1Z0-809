package Chapter11_Concurrency.Questions;

public class Question7 {

//    Which method represents the best approach to generating a random number between 1 and 10 if the method will be
//    called concurrently and repeatedly by multiple threads?

//    A. public static int randomA() {
//          Random r = new Random();
//          return r.nextInt(10) + 1;
//       }
//    B. private static Random sr = new Random();
//       public static int randomB() {
//          return sr.nextInt(10) + 1;
//       }
//    C. public static int randomC() {
//          int i = (int) (Math.random() * 10 + 1);
//          return i;
//       }
//    D. public static int randomD() {                              --> CORRECT
//          ThreadLocalRandom lr = ThreadLocalRandom.current();
//          return lr.nextInt(1, 11);
//       }
}


// D is correct. The ThreadLocalRandom creates and retrieves Random instances that are specific to a thread. You could
// achieve the same effect prior to Java 7 by using the java.lang.ThreadLocal and java.util.Random classes, but it would
// require several lines of code. Math.random() is thread-safe, but uses a shared java.util.Random instance and can
// suffer from contention problems.
//
// A, B, and C are incorrect based on the above. (OCP Objective 10.1)
