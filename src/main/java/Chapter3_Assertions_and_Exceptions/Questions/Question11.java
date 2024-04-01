package Chapter3_Assertions_and_Exceptions.Questions;

public class Question11 {
    static class PowerOutage extends Exception {}
    static class ThunderStorm extends Exception {}

    public static void main(String[] args) {
        try {
            new Question11().listen();
            System.out.print("a");
        } catch (PowerOutage | ThunderStorm e) {
//            e = new PowerOutage();            // need to comment so code will compile
            System.out.print("b");
        } finally {
            System.out.print("c");
        }
    }
    public void listen() throws PowerOutage, ThunderStorm {}
}
// What will this code print?

// A. a
// B. ab
// C. ac
// D. abc
// E. bc
// F. Compilation fails --> CORRECT