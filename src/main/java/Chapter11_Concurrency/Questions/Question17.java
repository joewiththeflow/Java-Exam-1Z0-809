package Chapter11_Concurrency.Questions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Question17 {

    public static void main(String[] args) {

        Stream<List<String>> sDogNames = Stream.generate(() -> Arrays.asList("boi", "aiko", "charis", "zooey", "clover"))
                .limit(2).unordered();
        sDogNames.parallel()
                .flatMap(s -> s.stream())
                .map(s -> s.toUpperCase())
                .forEach(s -> System.out.print(s + " "));
    }

//    What is the result?

//    A. BOI AIKO CHARIS ZOOEY CLOVER BOI AIKO CHARIS ZOOEY CLOVER
//    B. Most likely although not guaranteed: BOI AIKO CHARIS ZOOEY CLOVER BOI AIKO CHARIS ZOOEY CLOVER     --> CORRECT
//    C. A ConcurrentModificationException is thrown
//    D. Compilation fails
//    E. An exception other than ConcurrentModificationException is thrown at runtime
}


// B is correct. Because of the limit(2), we will see the dog names twice, most likely in order. The limit() forces
// the stream to maintain state about the source data, so it is likely the stream will retain the original source
// ordering (although that is not guaranteed) even though it’s an unordered parallel stream.