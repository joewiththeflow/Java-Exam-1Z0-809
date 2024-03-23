package Chapter11_Concurrency.Questions;

import java.util.Optional;
import java.util.stream.Stream;

public class Question16 {

//     Given the following code fragment:

    public static void main(String[] args) {
        Stream<Integer> nums = Stream.of(10, 5, 3, 2);
        Optional<Integer> result =
                nums
                        .parallel()
                        .map(n -> n * 10)
                        .reduce((n1, n2) -> n1 - n2);
        System.out.println("Result: " + result.get());
    }


}

// What is the result?

// A. 0
// B. 40
// C. The result is unpredictable           --> CORRECT
// D. Compilation fails
// E. An exception is thrown at runtime



// C is correct. The result is unpredictable because the reduction function is not associative and the stream is parallel.

