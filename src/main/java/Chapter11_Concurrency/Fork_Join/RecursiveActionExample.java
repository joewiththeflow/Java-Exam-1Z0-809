package Chapter11_Concurrency.Fork_Join;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.ThreadLocalRandom;

public class RecursiveActionExample extends RecursiveAction {
    private static final int THRESHOLD = 10000;
    private int[] data;
    private int start;
    private int end;

    public RecursiveActionExample(int[] data, int start, int end) {
        this.data = data;
        this.start = start;
        this.end = end;
    }

    @Override
    protected void compute() {
        if (end - start <= THRESHOLD) {     // is it still a manageable amount of work?
            // do the task
            for (int i = start; i < end; i++) {
                data[i] = ThreadLocalRandom.current().nextInt();
            }
        } else {                            // task too big so split
            int halfWay = ((end - start) / 2) + start;
            RecursiveActionExample a1 = new RecursiveActionExample(data, start, halfWay);
            a1.fork();  // queue left half of task
            RecursiveActionExample a2 = new RecursiveActionExample(data, halfWay, end);

            a2.compute();   // work on right half of task
            a1.join();      // wait for queued task to be completed

            // fork(), compute() and join() can be replaced by a single invokeAll() method:
//                invokeAll(a2, a1)
            // this will execute the first task passed to it, a2 (compute()), and additional tasks are forked and joined
        }
    }

    public static void main(String[] args) {
        int[] data = new int[10_000_000];
        ForkJoinPool fjPool = new ForkJoinPool();
        RecursiveActionExample action = new RecursiveActionExample(data, 0, data.length);
        fjPool.invoke(action);

        // RecursiveAction doesn't actually return anything
    }
}
