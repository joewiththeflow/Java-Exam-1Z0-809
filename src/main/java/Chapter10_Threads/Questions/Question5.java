package Chapter10_Threads.Questions;

public class Question5 {
    public static void main(String[] args) {
        System.out.print("1 ");
        synchronized(args) {
            System.out.print("2 ");
            try {
                args.wait();
            } catch (InterruptedException e) {}
        }
        System.out.print("3 ");
    }
}

// What is the result of trying to run this program?

// A. It fails to compile because the IllegalMonitorStateException of wait() is not dealt with on line 9
// B. 1 2 3
// C. 1 3
// D. 1 2       --> CORRECT
// E. At runtime, it throws an IllegalMonitorStateException when trying to wait
// F. It will fail to compile because it has to be synchronized on the this object