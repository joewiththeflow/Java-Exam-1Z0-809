package Chapter9_Streams.Stream_Of_Streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class StreamOfStreamsExample {

    public static void main(String[] args) {

        try {
            // Imagine we have a file and we want to see how many times the word "Java" appears in it
            // We could try the below:
            Stream<String> input = Files.lines(Paths.get("src/main/java/Chapter9_Streams/Stream_Of_Streams/java.txt"));
            // the next line would produce a Stream<String[]>
            Stream<String[]> inputStream = input.map(line -> line.split(" "));
            // We could instead try mapping each String[] to a stream so each array becomes a stream of Strings
//            inputStream.map(array -> Arrays.stream(array)).forEach(System.out::println);
            // But this actually produces:
            // java.util.stream.ReferencePipeline$Head@2d98a335
            // java.util.stream.ReferencePipeline$Head@16b98e56
            // java.util.stream.ReferencePipeline$Head@7ef20235
            // java.util.stream.ReferencePipeline$Head@27d6c5e0
            // java.util.stream.ReferencePipeline$Head@4f3f5b24
            // What we've done is create a stream of streams:  Stream<Stream<String>>
            // so when we try to print, we're actually printing each Stream<String>

            // It turns out that there is a solution to this with the flatMap() method
            // flatMap maps a stream of one type into another type, but it "flattens" out the streams, essentially
            // concatenating them into one stream

            // So instead of mapping each array to a Stream, we will flat map each array to one big Stream
            // If we used this we could see every word in the file
            Stream<String> ss = inputStream.flatMap(array -> Arrays.stream(array));
            ss.forEach(System.out::println);

            // So we can combine this with using a filter to solve the initial problem:

            long n = Files.lines(Paths.get("src/main/java/Chapter9_Streams/Stream_Of_Streams/java.txt"))
                    .map(line -> line.split(" "))
                    .flatMap(array -> Arrays.stream(array))
                    .filter(w -> w.equals("Java"))
                    .count();
            System.out.println("Number of times 'Java' appears: " + n);

        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
