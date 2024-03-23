package Chapter11_Concurrency.Parallel_Streams;

import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

/*
* Sum numbers in an array of SIZE random numbers
* from 1 to MAX if number > NUM
 */
public class RecursiveTaskExample extends RecursiveTask<Long> {
    public static final int SIZE = 400_000_000;
    public static final int THRESHOLD = 1000;
    public static final int MAX = 10;           // array of numbers 1 to 10
    public static final int NUM = 5;            // sum numbers greater than 5
    private int[] data;
    private int start;
    private int end;

    public RecursiveTaskExample(int[] data, int start, int end) {
        this.data = data;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        long tempSum = 0;
        if (end - start <= THRESHOLD) {
            for(int i = start; i < end; i++) {
                if (data[i] > NUM) {
                    tempSum += data[i];
                }
            }
            return tempSum;
        } else {
            int halfWay = ((end - start) / 2) + start;
            RecursiveTaskExample t1 = new RecursiveTaskExample(data, start, halfWay);
            RecursiveTaskExample t2 = new RecursiveTaskExample(data, halfWay, end);
            t1.fork();                  // queue left half of task
            long sum2 = t2.compute();   // compute right half
            long sum1 = t1.join();      // compute left half and join
            return sum1 + sum2;
        }
    }

    public static void main(String[] args) {
        int[] data2sum = new int[SIZE];
        long sum = 0, startTime, endTime, duration;
        // create an array of random numbers between 1 and MAX
        for(int i = 0; i < SIZE; i++) {
            data2sum[i] = ThreadLocalRandom.current().nextInt(MAX) + 1;
        }
        startTime = Instant.now().toEpochMilli();
        // sum numbers with plain old for loop
        for(int i =0; i< data2sum.length; i++) {
            if(data2sum[i] > NUM) {
                sum = sum + data2sum[i];
            }
        }
        endTime = Instant.now().toEpochMilli();
        duration = endTime - startTime;
        System.out.println("Summed with for loop in " + duration + " milliseconds; sum is " + sum);


        // sum numbers with RecursiveTask
        ForkJoinPool fjp = new ForkJoinPool();
        RecursiveTaskExample action = new RecursiveTaskExample(data2sum, 0, data2sum.length);
        startTime = Instant.now().toEpochMilli();
        sum = fjp.invoke(action);
        endTime = Instant.now().toEpochMilli();
        duration = endTime - startTime;
        System.out.println("Summed with recursive task in " + duration + " milliseconds; sum is: " + sum);

        // sum numbers with a parallel stream
        IntStream stream2sum = IntStream.of(data2sum);
        startTime = Instant.now().toEpochMilli();
        sum =
                stream2sum
                        .unordered()
                        .parallel()
                        .filter(i -> i > NUM)
                        .sum();
        endTime = Instant.now().toEpochMilli();
        duration = endTime - startTime;
        System.out.println("Stream data summed in " + duration + " milliseconds; sum is: " + sum);

        // sum numbers with a parallel stream, limiting workers
        ForkJoinPool fjp2 = new ForkJoinPool(4);
        IntStream stream2sum2 = IntStream.of(data2sum);
        try {
            startTime = Instant.now().toEpochMilli();
            sum =
                    fjp2.submit(
                            () -> stream2sum2
                                    .unordered()
                                    .parallel()
                                    .filter(i -> i > NUM)
                                    .sum()
                    ).get();
            endTime = Instant.now().toEpochMilli();
            duration = endTime - startTime;
            System.out.println("FJP4 Stream data summed in " + duration + " milliseconds; sum is: " + sum);
        } catch (Exception e) {
            System.out.println("Error executing stream sum");
            e.printStackTrace();
        }
    }
}
