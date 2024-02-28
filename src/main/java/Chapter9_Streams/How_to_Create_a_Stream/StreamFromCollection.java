package Chapter9_Streams.How_to_Create_a_Stream;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class StreamFromCollection {
    public static void main(String[] args) {

        List<Double> tempsInPhoenix = Arrays.asList(123.6, 118.0, 113.0, 112.5, 115.8, 117.0, 110.2, 110.1, 106.0, 106.4);
        System.out.println("Number of days over 110 in 10 day period: " +
                tempsInPhoenix
                        .stream()
                        .filter(t -> t > 110.0)
                        .count());

        // To make it clear how the stream is created and stored as a variable - remember it has no data itself
        Stream<Double> tempStream = tempsInPhoenix.stream();
        System.out.println("Number of days over 110 in 10 day period: " +
                tempStream
                        .filter(t -> t > 110.0)
                        .count());

        // The Collection interface has a default method for creating a stream, which is inherited by child interfaces:
//        default Stream<E> stream()

        // However, remember that Map (HashMap, TreeMap etc.) do not inherit from Collection
        // If you want to stream a Map, you must first use the entrySet() method to turn the Map into a Set - Set is
        // a Collection type

        Map<String, Integer> myMap = new HashMap<>();
        myMap.put("Boi", 6);
        myMap.put("Zooey", 3);
        myMap.put("Charis", 8);
        System.out.println("Number of items in the map with value > 4: " +
                myMap
                        .entrySet()             // get a Set of Map.Entry objects
                        .stream()               // stream the Set
                        .filter(d -> d.getValue() > 4)
                        .count());
    }
}
