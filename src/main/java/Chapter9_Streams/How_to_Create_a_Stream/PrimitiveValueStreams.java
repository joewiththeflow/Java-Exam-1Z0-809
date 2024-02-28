package Chapter9_Streams.How_to_Create_a_Stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class PrimitiveValueStreams {

    public static void main(String[] args) {

        // There are primitive streams to avoid autoboxing e.g. DoubleStream, IntStream, LongStream

        DoubleStream s3 = DoubleStream.of(406.13, 406.42, 407.18, 409.01);

        // Keep in mind the difference between a Stream<Double> and DoubleStream.
        // The first is a stream of Double objects and the second is a stream of double values

        // If you create a List<Double> and then stream it:
        List<Double> co2Monthly = Arrays.asList(406.13, 406.42, 407.18, 409.01);
        Stream<Double> s1 = co2Monthly.stream();

        // the stream is type Stream<Double> - don't get fooled on the exam by this small distinction
    }
}
