package Chapter9_Streams.What_is_a_Stream;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamExamples {

    public static void main(String[] args) {

        Integer[] myNums = { 1, 2, 3 };
        // A stream is not a data structure like and array
        // Here we are creating a stream and saying that the array myNums is the source of that stream
        Stream<Integer> myStream = Arrays.stream(myNums);       // stream the array

        // You won't see data printed here - a stream is not a data structure
        // You'll see a reference to the object that describes how to get at the data
        System.out.println(myStream);

        // Get the number of elements in the stream
        long numElements = myStream.count();
        System.out.println("Number of elements in the stream: " + numElements);

        // At this point the stream is done and no more operations can be performed on it
        // We say that count() is a "terminal operation" because the stream ends and no more data flows through the stream

        // The real power of streams comes from the "intermediate operations" you can perform between the source and the
        // end of the stream.For instance you could filter for even numbers (intermediate operation one), multiply each of
        // those even numbers by 2 (intermediate operation 2) and then display the results in the console (terminal operation)

        // By specifying multiple operations on a stream, you are essentially defining a set of things you want to do in
        // a particular order to the data in the source. You COULD write it all using a for() loop and multiple lines of code
        // (possibly even using one or more temporary or new data structures), but with streams, you can be more concise

        // You have to create a new stream

        Stream<Integer> myStream2 = Arrays.stream(myNums);
        long numElements2 = myStream2
                .filter((i) -> i > 1)                       // the filter method actually produces a new stream
                .count();
        System.out.println("Number of elements > 1: " + numElements2);


        Stream<Integer> myStream3 = Arrays.stream(myNums);
        long numElements3 = myStream3.filter((i) -> i > 1).count();
        System.out.println("The number of elements > 1: " + numElements3);
//        numElements3 = myStream3.filter((i) -> i > 2).count();                // won't work as count() was terminal operation
//        System.out.println("The number of elements > 2: " + numElements3);

        // Streams are lightwieght objects so you can just create the stream again
        numElements3 =
                Arrays.stream(myNums)
                        .filter((i) -> i > 2)
                        .count();
        System.out.println("Number of elements > 2: " + numElements3);
    }
}
