package Chapter11_Concurrency.Parallel_Streams;

import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

public class StatefulStreamsExamples2 {

    public static void main(String[] args) {
        final int SIZE = 400_000_000;
        final int LIMIT = 5;
        long sum = 0, startTime, endTime, duration;

        ForkJoinPool fjp = new ForkJoinPool(1);     // Limit to 1 thread
//        ForkJoinPool fjp = new ForkJoinPool(2);               // Use 2 threads
        IntStream stream = IntStream.range(0, SIZE);
        try {
            startTime = Instant.now().toEpochMilli();
            sum = fjp.submit(
                    () -> stream
//                            .parallel()                           // make parallel
                            .limit(LIMIT)
                            .sum()
            ).get();
            endTime = Instant.now().toEpochMilli();
            duration = endTime - startTime;
            System.out.println("FJP Stream data summed in " + duration + "milliseconds; sum is: " + sum);
        } catch (Exception e) {
            System.out.println("Error executing stream sum");
            e.printStackTrace();
        }
    }

    // Increasing the workers and making stream parallel is actually slightly slower
    // Not by much but indicates that you won't get benefit from using parallel
}
