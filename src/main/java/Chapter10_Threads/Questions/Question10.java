package Chapter10_Threads.Questions;

public class Question10 extends Thread {
    Question10() {
        System.out.print("MyThread ");
    }
    @Override
    public void run() {
        System.out.println("bar");
    }
    public void run(String s) {
        System.out.println("baz ");
    }
}

class TestThreads {
    public static void main(String[] args) {
        Thread t = new Question10() {
            public void run() {
                System.out.println("foo ");
            }
        };
        t.start();
    }
}

// What is the result?

// A. foo
// B. MyThread foo              --> CORRECT
// C. MyThread bar
// D. foo bar
// E. foo bar baz
// F. bar foo
// G. Compilation fails
// H. An exception is thrown at runtime
