package Chapter2_Object_Orientation.Questions;
interface i1 {
    void doStuff(int x);
}
class Patton {
    void stuff(String s) {
        System.out.println("stuff ");
    }
}
//public class Question17 extends Patton implements i1 {
//    public static void main(String[] args) {
//        new Question17().doStuff(1);
//        new Question17().stuff("x");
//    }
////    @Override
////    void doStuff(int x) {                 // You have to make this "public"
////        System.out.println("doStuff ");
////    }
//    @Override
//    void stuff(String s) {
//        System.out.println("my stuff ");
//    }
//}

// What is the result? (Choose all tha apply)

// A. Stuff stuff
// B. doStuff stuff
// C. doStuff my stuff
// D. An exception is thrown at runtime
// E. Compilation fails due to an @Override related error
// F. Compilation fails due to an error other than an @Override related error       --> CORRECT