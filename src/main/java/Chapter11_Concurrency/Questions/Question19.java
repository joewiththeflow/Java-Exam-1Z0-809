package Chapter11_Concurrency.Questions;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;

public class Question19 {

    public static void main(String[] args) {
        List<Integer> myNums = Arrays.asList(1, 2, 3, 4, 5);
        OptionalInt aNum = myNums.parallelStream().mapToInt(i -> i * 2).findAny();
        aNum.ifPresent(System.out::println);
    }

//    What is the result?

//    A. 1
//    B. 2
//    C. The result is unpredictable; it could be any one of the numbers in the stream      --> CORRECT
//    D. A ConcurrentModificationException is thrown
//    E. Compilation fails
//    F. An exception is thrown at runtime
}

// C is correct. For a parallel stream, any of the numbers can be multiplied by 2 and returned by findAny()