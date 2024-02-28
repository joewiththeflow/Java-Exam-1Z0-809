package Chapter9_Streams.How_to_Create_a_Stream;

import java.util.Arrays;
import java.util.List;

public class WhyStreams {
    public static void main(String[] args) {

        // The main reason to use streams is when you start doing multiple intermediate operations

        List<String> names = Arrays.asList("Boi", "Charis", "Zooey", "Bokeh", "Clover", "Aiko");
        names.stream()
                .filter(s -> s.startsWith("B") || s.startsWith("C"))    // filter by first letter
                .filter(s -> s.length() > 3)                            // filter by length
                .forEach(System.out::println);

        // You could achieve the same through iteration

        // However streams use something called a "pipeline", which can in some circumstances, dramatically improve
        // the efficiency of data processing.
    }
}
