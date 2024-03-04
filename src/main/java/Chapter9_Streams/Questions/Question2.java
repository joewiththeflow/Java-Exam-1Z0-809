package Chapter9_Streams.Questions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Question2 {
    public static void main(String[] args) {

        try (Stream<String> stream = Files.lines(Paths.get("src/main/java/Chapter9_Streams/Questions/names.txt"))) {
            List<String> names = stream.sorted().collect(Collectors.toList());      // L1
            System.out.println("Sorted names in the file: " + names);
        } catch (IOException e) {
            System.out.println("Error reading names.txt");
            e.printStackTrace();
        }

        // Which code fragments inserted at // L1 will produce a sorted List of names in the variables names?

        // A. List<String> names = stream.sorted.toList();
        // B. List<String> names = stream                                       // comparing is a method of Comparator
        //          .comparing((n1, n2) -> n1.compareTo(n2))
        //          .collect(Collectors.toList());
        // C. List<String> names = stream.collect(Collectors.toList()).sorted();
        // D. List<String> names = stream.sorted().collect(Collectors.toList());
    }
}
