package Chapter9_Streams.Generating_Streams;

import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IterateGenerateLimitSkip {

    public static void main(String[] args) {

        // The following code cretaes an infinite sequential Stream:

        Stream.iterate(0, s -> s + 1);

        // This does not create an infinite loop as nothing starts to happen until you call a terminal operation
        // The iterate() operation starts with a "seed", followed by the elements created by the UnaryOperator second arg.
        // In the example above, the stream will generate whole numbers starting at 0, adding 1 to the seed first and
        // then each subsequent number, forever

        // Don't try the following code:
//        Stream
//                .iterate(0, s -> s + 1)             // create an infinite stream
//                .forEach(System.out::println);

        // The forEach() terminal operation will never end because the stream is infinite
        // We could get around this by using the limit() operation

        Stream
                .iterate(0, s -> s + 1)             // create an infinite stream
                .limit(4)                       // but limit it to 4 things
                .forEach(System.out::println);

        // Produces:
        // 0
        // 1
        // 2
        // 3

        // To work safely with infinite streams you need a short-circuiting operation
        // Could be limit() or it could be findFirst(), findAny() or anyMatch()

        // Let's simulate a sensor and use generate() which uses a Supplier
        // The generate() method generates an infinite stream from elements supplied by the Supplier
        // Our Supplier is going to get values from the sendor to stream:

        Sensor s = new Sensor();
        Stream<String> sensorStream = Stream.generate(() -> s.next()); // will contain 10 "up" elements, potentially
                                                                        // an infinite number of "down"
        // Look for the first "down" value in the stream
        Optional<String> result =
                sensorStream
                        .filter(v -> v.equals("down"))      // filter to get all "down" values
                        .findFirst();                       // find first one
        result.ifPresent(System.out::println);

        // This does of course there will be a "down" value, otherwise it will keep streaming forever

        // We can also use range() on primitive streams, IntStream and LongStream:
        IntStream numStream = IntStream.range(10, 15);      // generate numbers 10...14
        numStream.forEach(System.out::println);

        // Produces
        // 10
        // 11
        // 12
        // 13
        // 14

        // If you want a range of numbers inclusive of the send argument use:
        IntStream numStream2 = IntStream.rangeClosed(10, 15);       // generate numbers 10...15
        numStream2.forEach(System.out::println);

        // Produces:
        // 10
        // 11
        // 12
        // 13
        // 14
        // 15

        // Could limit() to get the first 5 even numbers in a stream:

        IntStream evensBefore10 =
                IntStream.rangeClosed(0, 20)
                        .filter(i -> i % 2 == 0)
                        .limit(5);
        evensBefore10.forEach(System.out::println);

        // Produces:
        // 0
        // 2
        // 4
        // 6
        // 8

        // and you can use skip() to print the even numbers between 10 and 20:
        IntStream evensAfter10 =
                IntStream.rangeClosed(0, 20)
                        .filter(i -> i % 2 == 0)
                        .skip(5);
        evensAfter10.forEach(System.out::println);

        // Produces:
        // 10
        // 12
        // 14
        // 16
        // 18
        // 20
    }
}

class Sensor {
    String value = "up";
    int i = 0;
    public Sensor() {}

    public String next() {
        i = i + 1;
        return i > 10 ? "down" : "up";
    }
}
