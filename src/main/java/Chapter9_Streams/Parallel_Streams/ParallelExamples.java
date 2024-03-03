package Chapter9_Streams.Parallel_Streams;

import java.util.Arrays;
import java.util.List;

public class ParallelExamples {
    public static void main(String[] args) {

        // Serial Sum (one thread handling the sum operation):
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int sum = nums.stream()
                .mapToInt(n -> n)           // need to map from Integer to int
                .sum();
        System.out.println("Sum is: " + sum);

        // Parallel Sum (multiple threads handling sum operation):
        List<Integer> nums2 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int sum2 = nums.stream()
                .parallel()
                .mapToInt(n -> n)           // need to map from Integer to int
                .sum();
        System.out.println("Sum is: " + sum);



        // Parallel Stream should be faster, but you must take care when depending on an order

        // Serial Stream:
        Arrays.asList("boi", "charis", "zooey", "aiko")
                .stream()
                .forEach(System.out::println);

        // Produces:
        // boi
        // charis
        // zooey
        // aiko

        // Parallel Stream:
        Arrays.asList("boi", "charis", "zooey", "aiko")
                .stream()
                .parallel()
                .forEach(System.out::println);

        // Produces (but could be a different order every time):
        // zooey
        // aiko
        // boi
        // charis
    }
}
