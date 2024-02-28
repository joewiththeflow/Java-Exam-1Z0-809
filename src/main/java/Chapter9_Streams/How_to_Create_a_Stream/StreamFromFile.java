package Chapter9_Streams.How_to_Create_a_Stream;

import Chapter6_Generics_and_Collections.Using_Collections.DVDInfo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamFromFile {

    public static void main(String[] args) {

        // Using a stream to process data in a file is easy. You know you can use Files to read data from a file.
        // The static lines() method of Files returns a Stream, so we can stream the data using the file as a source.

        // Here is the signature of the Files.lines() method:

        // public static Stream<String> lines(Path path) throws IOException

        // So to create a Stream from a file:
        // Stream<String> stream = Files.lines(Paths.get(filename))

        // Then to rpocess the data fom the Stream you use the Stream's forEach() method:
        // stream.forEach(line -> ... do something with the line of data from the file)

        // Here's an example using the DVDInfo class and text file from before:

        List<DVDInfo> dvds = loadDVDs("src/main/java/Chapter6_Generics_and_Collections/Using_Collections/dvdinfo.txt");
        dvds.forEach(System.out::println);

        // Remember within a lambda expression you can't modify variables
        // However, we CAN modify fields of an object within a lambda
        // That's why below we can add DVDInfo items to the dvds list - apparently a better way will be revealed

    }

    public static List<DVDInfo> loadDVDs(String filename) {
        List<DVDInfo> dvds = new ArrayList<>();
        // stream a file line by line
        try (Stream<String> stream = Files.lines(Paths.get(filename))) {
            stream.forEach(line -> {                                // forEach is a terminal operation
                String[] dvdItems = line.split("/");
                DVDInfo dvd = new DVDInfo(dvdItems[0], dvdItems[1], dvdItems[2]);
                dvds.add(dvd);          // for now; there is a better way
            });
        } catch (IOException e) {
            System.out.println("Error reading DVDs");
            e.printStackTrace();
        }
        return dvds;
    }
}
