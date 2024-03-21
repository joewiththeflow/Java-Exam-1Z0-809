package Chapter11_Concurrency.Parallel_Streams;

import java.util.Arrays;
import java.util.List;

public class StatelessStreamExamples {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        long sum = nums.stream()
                .parallel()
                .mapToInt(n -> n)
                .filter(i ->
                        i % 2 == 0 ? true : false)
                .sum();
        System.out.println("Sum of evens is: " + sum);
    }
}
