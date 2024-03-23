package Chapter11_Concurrency.Questions;

import java.util.concurrent.RecursiveAction;

public class Question14 extends RecursiveAction {
    private final int threshold;
    private final int[] myArray;
    private int start;
    private int end;

    public Question14(int[] myArray, int start, int end, int threshold) {
        this.threshold = threshold;
        this.myArray = myArray;
        this.start = start;
        this.end = end;
    }

    @Override
    protected void compute() {
        if (end - start < threshold) {
            for (int i = start; i <= end; i++) {
                myArray[i]++;
            }
        } else {
            int midway = (end - start) / 2 + start;
            Question14 a1 = new Question14(myArray, start, midway, threshold);
            Question14 a2 = new Question14(myArray, midway + 1, end, threshold);
            // insert answer here
        }
    }
}

// Which line(s) when inserted at the end of the compute method, would correctly take the place of separate calls to
// fork() and join()? (Choose all that apply)

// A. compute();
// B. forkAndJoin(a1, a2);
// C. computeAll(a1, a2);
// D. invokeAll(a1, a2);        --> CORRECT
