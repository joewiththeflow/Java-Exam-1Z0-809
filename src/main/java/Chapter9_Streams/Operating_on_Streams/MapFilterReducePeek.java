package Chapter9_Streams.Operating_on_Streams;

import java.util.Arrays;
import java.util.List;

public class MapFilterReducePeek {

    public static void main(String[] args) {

        // One way to describe streams is through the abstraction: map - filter - reduce

        // map() is an intermediate option, however unlike filter it does not winnow the elements of the stream
        // map() transforms elements of a stream e.g.
            // compute the square of a number, mapping a stream of numbers to their squares
            // might get the age of a Person object so that the next step e.g. a filter can find ages greater than 21

        // map() takes a Function - the purpose of a Function is to transform a value
        // the Function you pass map() will map will "map" one value to another

        // reduce() is a general method for reducing the stream to a value; the basic version of reduce takes a
        // BiFunction (apply() method takes two args and returns one value) and applies it to pairs of elements from the
        // stream, returning a value
        // Think of it as a way to "accumulate" a result
        // count(), sum() and average() are reduction methods available to streams
        // You can define your own custom BiFunction for reduce()

        // The Java 7 way:

        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5,6);
        long result = 0;
        for(Integer n : nums) {
            int square = n * n;
            if (square > 20) {
                result = result + 1;
                System.out.println("Square of " + n + " is: " + square);
            }
        }
        System.out.println("Result: " + result);

        // The Java 8 way:

        List<Integer> nums2 = Arrays.asList(1, 2, 3, 4, 5, 6);
        long result2 = nums2.stream()
                .map(n -> n * n)            // map intermediate op
                .filter(n -> n > 20)        // filter intermediate op
                .count();                    // reduction op
        System.out.println("Result (stream): " + result2);


        // Notice that we can't print the original number with its square in the stream method
        // There is a "sort of" solution to a problem like this however:

        long result3 = nums2.stream()
                .peek(n -> System.out.print("Number is: " + n + ", "))
                .map(n -> n * n)
                .filter(n -> n > 20)
                .peek((n -> System.out.println("Square is: " + n + ", ")))
                .count();

        // peek() takes a Consumer and produces the same exact stream as it's called on so doesn't change or filter
        // the values in any way
    }
}
