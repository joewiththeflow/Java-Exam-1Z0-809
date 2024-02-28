package Chapter9_Streams.How_to_Create_a_Stream;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamFromArray {

    public static void main(String[] args) {

        String[] dogs = { "Boi", "Zooey", "Charis" };
        Stream<String> dogStream = Arrays.stream(dogs);
        System.out.println("Number of dogs in array: " + dogStream.count());

        // You'd never actually use a stream just to count objects but this is just an example

        // We can of course use Stream.of() to create the Stream from an array
        Stream<String> dogStream2 = Stream.of(dogs);
    }
}
