package Chapter1_Declarations_AccessControl_Enums.Questions;

interface Gadget {
    void doStuff();                         // this is implicitly public!
}
abstract class Electronic2 {
    void getPower() {
        System.out.print("plug in ");
    }
}
//public class Question8 extends Electronic2 implements Gadget {
////    void doStuff() {                      // you need to recognise that you are trying to implement a method
                                              // with default access when it has to be public
////        System.out.print("show book ");
////    }
//
//    public static void main(String[] args) {
//        new Question8().getPower();
//        new Question8().doStuff();
//    }
//}

// Which are true?

// A. The class Question 8 will NOT compile             --> CORRECT
// A. The interface Gadget will NOT compile
// C. The output will be plug in show book
// D. The abstract class Electronic2 will NOT compile
// E. The class Question 8 cannot both extend and implement