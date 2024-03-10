package Chapter10_Threads.Questions;

public class Question3 {
    public static void main(String[] args) {
        printAll(args);
    }

    private static void printAll(String[] lines) {
        for (int i = 0; i < lines.length; i++) {
            System.out.println();
//            Thread.currentThread().sleep();   -- Need to comment but shouldn't be commented for question
        }
    }
}

// What is the result?

// A. Each String in the array lines will output, with a one second pause between lines
// B. Each String in the array lines will output, with no pause between because this method is not executed in a Thread
// C. Each String in the array lines will output,  and there is no guarantee that there will be a pause because
//    currentThread() may not retrieve this thread
// D. The code will not compile                     --> CORRECT, need a try/catch around sleep()
// E. Each String in the lines array will print, with a least a one second pause between lines
