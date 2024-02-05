package Chapter7_Inner_Classes.Qs;

public class Question9 {
    class Engine {
//        { Question9.drive(); }
//        { this.drive(); }
//        { Question9.this.drive(); }
//        { this.Question9.this.drive(); }
//        Engine() { Question9.drive();}
//        Engine() {Question9.drive();}
        Engine() {Question9.this.drive();}
    }

    public static void main(String[] args) {
        new Question9().go();
    }

    void go() {
        new Engine();
    }

    void drive() {
        System.out.println("hi");
    }
}
