package Chapter9_Streams.Questions;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;

public class Question10 {
    public static void main(String[] args) {

        // What is the correct TYPE for minInteger?

        List<Integer> myInts = Arrays.asList(5, 10, 7, 2, 8);
        // TYPE minInteger = myInts.stream().mapToInt(i -> i).min();

        // A. int
        // B. Integer
        // C. OptionalInt           --> CORRECT
        // D. Optional<Integer>
        // E. Stream<Integer>
        // F. IntStream
    }
}
