package Chapter8_Lambda_Expressions.Questions;

public class Question1 {

    // Which of the following are functional interfaces?

    // A.
    //      interface Question {
    //          default int answer() {
    //              return 42;
    //          }
    //      }

    // B.                                       ---> CORRECT
    //      interface Tree {
    //          void grow();
    //      }

    // C.
    //      interface Book {
    //          static void read() {
    //              System.out.println("Turn the page...");
    //          }
    //      }

    // D.                                       ---> CORRECT, you are allowed to override methods from Object and
    //                                          and have default/static methods
    //      interface Flower {
    //          boolean equals(Object f);
    //          default void bloom() {
    //              System.out.println("Petals are opening");
    //          }
    //          String pick();
}
