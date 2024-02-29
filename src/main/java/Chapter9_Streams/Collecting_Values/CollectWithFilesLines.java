package Chapter9_Streams.Collecting_Values;

import Chapter6_Generics_and_Collections.Using_Collections.DVDInfo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectWithFilesLines {
    public static void main(String[] args) {

        String filename = "src/main/java/Chapter9_Streams/Collecting_Values/names.txt";
        try (Stream<String> stream = Files.lines(Paths.get(filename))) {
            List<String> data = stream.collect(Collectors.toList());
            data.forEach(System.out::println);
        } catch (IOException e) {
            System.out.println(e);
        }

        // We're then asked to improve the previous code we had to read each line from the dvd file
        // So let's try to create the same thing but by using collect()
        List<DVDInfo> dvds = loadDVDsUsingCollect("src/main/java/Chapter6_Generics_and_Collections/Using_Collections/dvdinfo.txt");
        dvds.forEach(System.out::println);
    }

    public static List<DVDInfo> loadDVDsUsingCollect(String filename) {
        List<DVDInfo> dvds = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get(filename))) {
            dvds = stream.map(line -> {
                String[] dvdItems = line.split("/");
                return new DVDInfo(dvdItems[0], dvdItems[1], dvdItems[2]);
            })
                            .collect(Collectors.toList());

        } catch (IOException e) {
            System.out.println("Error reading DVDs");
            e.printStackTrace();
        }
        return dvds;
    }

    // This was the old method I used
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

