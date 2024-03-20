package Chapter11_Concurrency.Fork_Join;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class RecursiveTaskExample extends RecursiveTask<Integer> {
    private static final int THRESHOLD = 10000;
    private int[] data;
    private int start;
    private int end;

    public RecursiveTaskExample(int[] data, int start, int end) {
        this.data = data;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {               // return type matches the <generic> type
        if (end - start <= THRESHOLD) {         // is it a manageable amount of work?
            int position = 0;                   // if all values are equal, return position 0

            for (int i = start; i < end; i++) {
                if (data[i] > data[position]) {
                    position = i;
                }
            }
            return position;
        } else {                                // task too big, split it
            int halfWay = ((end - start) / 2) + start;
            RecursiveTaskExample t1 = new RecursiveTaskExample(data, start, halfWay);
            t1.fork();                          // queue left half of task
            RecursiveTaskExample t2 = new RecursiveTaskExample(data, halfWay, end);
            int position2 = t2.compute();   // work on right half of task
            int position1 = t1.join();      // wait for the queued task to complete
            // out of the position in the two subsections, which is greater?
            if (data[position1] > data[position2]) {
                return position1;
            } else if (data[position1] < data[position2]) {
                return position2;
            } else {
                return position1 < position2 ? position1 : position2;
            }
        }
    }

    public static void main(String[] args) {
        int[] data = new int[10_000_000];
        ForkJoinPool fjPool = new ForkJoinPool();
        RecursiveActionExample action = new RecursiveActionExample(data, 0, data.length);
        fjPool.invoke(action);

        RecursiveTaskExample task = new RecursiveTaskExample(data, 0, data.length);
        Integer position = fjPool.invoke(task);
        System.out.println("Position: " + position + ", value: " + data[position]);
    }
}
