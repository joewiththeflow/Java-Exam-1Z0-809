package Chapter9_Streams.Searching_and_Sorting;

import Chapter8_Lambda_Expressions.Syntax.Dog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CollectExample {
    public static void main(String[] args) {

        List<Dog> dogs = new ArrayList<>();
        Dog boi = new Dog("boi", 30, 6);
        Dog clover = new Dog("clover", 35, 12);
        Dog aiko = new Dog("aiko", 50, 10);
        Dog zooey = new Dog("zooey", 45, 8);
        Dog charis = new Dog("charis", 120, 7);
        dogs.add(boi);
        dogs.add(clover);
        dogs.add(aiko);
        dogs.add(zooey);
        dogs.add(charis);

        // Never attempt to modify the source of a stream within the stream pipeline:
//        dogs.stream().filter(d -> {
//            if(d.getWeight() > 50) {
//                dogs.remove(d);
//                return false;
//            }
//            return true;
//        }).forEach(System.out::println);

        // Instead it's best to create a new list with Stream.collect():
        List<Dog> heavyDogs =
                dogs.stream()
                        .filter(d -> d.getWeight() >= 50)
                        .collect(Collectors.toList());
        heavyDogs.forEach(System.out::println);
    }
}
