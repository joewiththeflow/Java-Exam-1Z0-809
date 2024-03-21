package Chapter11_Concurrency.Parallel_Streams;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Stream;

public class ParallelStreamExample {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int sum = nums.stream()
                .parallel()             // make the stream parallel
                .peek(i -> System.out.println(i + ": " + Thread.currentThread().getName()))
                .mapToInt(n -> n)
                .sum();
        System.out.println("Sum is: " + sum);

        // We might want to tell the computer exactly how many workers to use
        // this is friendlier to the computer which may want some other cores to do other things while task runs

        ForkJoinPool fjp = new ForkJoinPool(2);
        try{
            int sum2 = fjp.submit(           // returns a Future (FutureTask)
                    () -> nums.stream()     // a Callable (value returning task)
                            .parallel()
                            .peek(i -> System.out.println(i + ": " + Thread.currentThread().getName()))
                            .mapToInt(n -> n)
                            .sum()
            ).get();                        // from Future; get() waits for computation to complete and gets the result
            System.out.println("FJP with 2 workers, sum is: " + sum2);
        } catch (Exception e) {
            System.out.println("Error executing stream sum");
            e.printStackTrace();
        }

        // You can also combine the stream() and parallel()

        int sum3 = nums.parallelStream()           // make the stream parallel
                .peek(i -> System.out.println(i + ": " + Thread.currentThread().getName()))
                .mapToInt(n -> n)
                .sum();
        System.out.println("Sum is: " + sum3);

        // You can use the isParallel() method on a stream which returns a boolean

        // You can also make a parallel stream into a serial stream:
        Stream<Integer> numsStream = nums.stream().parallel();
        System.out.println("Is stream parallel? " + numsStream.isParallel());
        numsStream.sequential();
        System.out.println("Is stream parallel? " + numsStream.isParallel());
    }




}
