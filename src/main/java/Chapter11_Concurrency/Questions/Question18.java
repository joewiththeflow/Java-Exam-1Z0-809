package Chapter11_Concurrency.Questions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Question18 {

    public static void main(String[] args) {

        Stream<List<String>> sDogNames2 =
                Arrays.asList(
                        Arrays.asList("boi", "aiko", "charis", "zooey", "clover"),
                        Arrays.asList("boi", "aiko", "charis", "zooey", "clover"))
                .stream().unordered();
        sDogNames2.parallel()
                .flatMap(s -> s.stream())
                .map(s -> s.toUpperCase())
                .forEach(s -> System.out.print(s + " "));
    }
}

// What is the result?

//    A. BOI AIKO CHARIS ZOOEY CLOVER BOI AIKO CHARIS ZOOEY CLOVER
//    B. The result is unpredictable                                    --> CORRECT
//    C. A ConcurrentModificationException is thrown
//    D. Compilation fails
//    E. An exception other than ConcurrentModificationException is thrown at runtime


// B is correct. Unlike the previous sample question, we have no limit() so we have a stateless stream pipeline.
// The stream is unordered, and the pipeline is executing in parallel, so we cannot predict the ordering of the output.
// Note that if we were using forEachOrdered() instead of forEach() as the terminal operation, it is likely, but not
// guaranteed, that we would see the results in the same ordering as the source