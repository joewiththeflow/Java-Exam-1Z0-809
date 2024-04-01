package Chapter2_Object_Orientation.Questions;

//interface I1 {
//    default int doStuff() { return 1; }     // implicitly public
//}
//interface I2 {
//    default int doStuff() { return 2; }     // implicitly public
//}
//public class MultiInt implements I1, I2 {

//    public static void main(String[] args) {
//        new Question15().go();
//    }
//    void go() {
//        System.out.println(doStuff());
//    }
//    int doStuff() {                   --> MUST be declared "public"
//        return 3;
//    }
//}

public class Question15 {

}
// What is the result?

// A. 1
// B. 2
// C. 3
// D. The output is unpredictable
// E. Compilation fails                 --> CORRECT, override of interface method must be public
// F. An exception is thrown at runtime