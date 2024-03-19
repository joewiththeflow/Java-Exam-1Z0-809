package Chapter11_Concurrency.Executors_and_ThreadPools;

import java.util.List;
import java.util.concurrent.*;

public class CallableExample implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        // Obtain a random number from 1 to 10
        int count = ThreadLocalRandom.current().nextInt(1, 11);
        for (int i = 1; i < count; i++) {
            System.out.println("Running..." + i);
        }
        return count;
    }

    public static void main(String[] args) {
        Callable<Integer> c = new CallableExample();
        ExecutorService ex = Executors.newCachedThreadPool();
        Future<Integer> f = ex.submit(c); // finishes in the future
        try {
            Integer v = f.get(); // blocks until done
            System.out.println("Ran: " + v);
        } catch (InterruptedException | ExecutionException iex) {
            System.out.println("Failed");
        }

       // ex.shutdown(); // no more tasks but finish existing tasks
        try {
            boolean term = ex.awaitTermination(2, TimeUnit.SECONDS);
            // wait 2 seconds for running tasks to finish
        } catch (InterruptedException ex1) {
            System.out.println("Did not wait 2 seconds");
        } finally {
            if (!ex.isTerminated())     // are all tasks done?
            {
                List<Runnable> unfinished = ex.shutdownNow();
                System.out.println(unfinished);
            }
        }
    }
}
