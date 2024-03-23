package Chapter11_Concurrency.Parallel_Streams;

import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Stream;

public class UnorderedExample {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Stream<Integer> s = nums.stream();
        System.out.println("Stream from list ordered? " + s.spliterator().hasCharacteristics(Spliterator.ORDERED));

        // setting a stream to undordered() before you call parallel gives performance benefits
        // otherwise the stream will maintain the state (List is ordered)

        List<Integer> nums2 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        long sum = nums2.stream()
                        .unordered()        // make the stream unordered
                        .parallel()
                        .mapToInt(n -> n)
                        .filter(i -> i % 2 == 0 ? true : false)
                        .sum();
        System.out.println("Sum of evens is: " + sum);
    }


}
