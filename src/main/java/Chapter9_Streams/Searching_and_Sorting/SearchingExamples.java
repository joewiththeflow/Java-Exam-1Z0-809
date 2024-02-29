package Chapter9_Streams.Searching_and_Sorting;

import Chapter8_Lambda_Expressions.Syntax.Dog;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SearchingExamples {

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

        // anyMatch() will stop searching as soon as it finds a match
        boolean cNames =
                dogs.stream()
                        .filter(d -> d.getWeight() > 50)
                        .anyMatch(d -> d.getName().startsWith("c"));
        System.out.println("Are there any dogs > 50 pounds whose name starts with 'c'? " + cNames);

        // allMatch()
        boolean isOlder =
                dogs.stream()
                        .mapToInt(d -> d.getAge())
                        .allMatch(a -> a > 5);
        System.out.println("Are all the dogs older than 5? " + isOlder);

        // noneMatch()
        boolean notRed =
                dogs.stream()
                        .map(d -> d.getName())
                        .noneMatch(n -> n.equals("red"));
        System.out.println("None of the dogs are red: " + notRed);

        // You can actually get back the results of a match using findFirst() and findAny()
        // you need to filter before calling these to narrow your search
        // both methods return optionals as there might be no elements to return

        Optional<Dog> c50 =
                dogs.stream()
                        .filter(d -> d.getWeight() > 50)
                        .filter(d -> d.getName().startsWith("c"))
                        .findAny();
        c50.ifPresent(System.out::println);

        // If there is more than one match, it will still only print one of them
        // These methods are short-circuiting meaning that everything stops as soon as a match is found
        // You also guarantee which one will be first, especially if you parallelize
        Optional<Dog> d5 =
                dogs.stream()
                        .filter(d -> d.getAge() > 5).peek(System.out::println)  // can add a peek but this won't change
                                                                                // anything, takes a Consumer and returns
                                                                                // the same stream
                        .findAny();
        d5.ifPresent(System.out::println);
    }
}
