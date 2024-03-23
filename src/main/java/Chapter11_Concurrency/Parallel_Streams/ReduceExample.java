package Chapter11_Concurrency.Parallel_Streams;

import java.util.Arrays;
import java.util.List;

public class ReduceExample {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int mult = nums.stream()
                .unordered()                            // for efficiency
                .parallel()
                .reduce(1, (i1, i2) -> i1 * i2);
        System.out.println("Product reduction: " + mult);
    }
}
