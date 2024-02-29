package Chapter9_Streams.Searching_and_Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class SortingExamples {

    public static void main(String[] args) {

        // Sort by natural order
        Stream.of("Jerry", "George", "Kramer", "Elaine")
                .sorted()
                .forEach(System.out::println);

        // Sort complex objects
        List<Duck> ducks = Arrays.asList(
                new Duck("Jerry", "yellow", 3),
                new Duck("George", "brown", 4),
                new Duck("Kramer", "mottled", 6),
                new Duck("Elaine", "white", 2),
                new Duck("Jerry", "mottled", 10),
                new Duck("George", "white", 12),
                new Duck("Kramer", "brown", 11),
                new Duck("Elaine", "brown", 13)
        );
        ducks.stream()
                .sorted()                       // Duck implements Comparable<Duck> and sorts on name
                .forEach(System.out::println);
        System.out.println();

        // sort on age instead with a comparator
        ducks.stream()
                .sorted((d1, d2) -> d1.getAge() - d2.getAge())
                .forEach(System.out::println);
        System.out.println();

        // You could also store the Comparator in a variable first
        Comparator<Duck> byAgeLambda = (d1, d2) -> d1.getAge() - d2.getAge();
        ducks.stream()
                .sorted(byAgeLambda)
                .forEach(System.out::println);
        System.out.println(

        );
        // There are some handy static methods in Comparator
        // For example, the comparing() method takes a Functin whose functional method expects a property to sort by
        // like Duck.age, as an argument and returns a Comparator that compares objects by that property
        Comparator<Duck> byColor = Comparator.comparing(Duck::getColor);
        Comparator<Duck> byName = Comparator.comparing(Duck::getName);
        Comparator<Duck> byAge = Comparator.comparing(Duck::getAge);

        // We can sort by age
        ducks.stream().sorted(byAge).forEach(System.out::println);
        System.out.println();

        // reverse it with reversed() method of Comparator:
        ducks.stream().sorted(byAge.reversed()).forEach(System.out::println);
        System.out.println();

        // You can also sort by one property and then another with the thenComparing() method
        ducks.stream().sorted(byName.thenComparing(byAge)).forEach(System.out::println);
        System.out.println();

        // Could also sort by color then age
        ducks.stream().sorted(byColor.thenComparing(byAge)).forEach(System.out::println);

        List<Duck> ducks2 = Arrays.asList(
                new Duck("Jerry", "yellow", 3),
                new Duck("George", "brown", 4),
                new Duck("Kramer", "mottled", 6),
                new Duck("Elaine", "white", 2),
                new Duck("Huey", "mottled", 2),
                new Duck("Louie", "white", 4),
                new Duck("Dewey", "brown", 6)
        );

        // Can also use the distinct() method from Stream
        // e.g. to get the colors, but printed only once for each color
        ducks2.stream()
                .map(d -> d.getColor())
                .distinct()
                .forEach(System.out::println);
    }
}

class Duck implements Comparable<Duck> {

    String name;
    String color;
    int age;

    public Duck(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Duck duck) {
        return this.getName().compareTo(duck.getName());
    }

    @Override
    public String toString() {
        return "Duck{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", age=" + age +
                '}';
    }
}