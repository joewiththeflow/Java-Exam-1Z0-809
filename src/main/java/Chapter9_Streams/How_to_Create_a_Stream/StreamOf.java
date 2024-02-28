package Chapter9_Streams.How_to_Create_a_Stream;

import java.util.stream.Stream;

public class StreamOf {

    public static void main(String[] args) {

        // Stream.of is quite flexible. It works with any object values so you can create a Stream of Strings, Integers
        // Doubles etc. The method signature is:

        // static <T> Stream<T> of(T... values)

        // meaning you can supply the of() method with any number of arguments and you get back an ordered stream of
        // those values

        Integer[] myNums = { 1, 2, 3 };
        Stream<Integer> myStream = Stream.of(myNums);

        // could make even shorter
        Stream<Integer> myStream2 = Stream.of(1, 2, 3);

        // The source of the Stream here is a little fuzzy; you aren't actually storing the data values in a data
        // structure first, like you are if you are streaming the myNums array. The source  is there, it's just hidden
        // behind the scenes
    }
}
