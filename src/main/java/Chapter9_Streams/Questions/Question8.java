package Chapter9_Streams.Questions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Question8 {
    public static void main(String[] args) {
        List<Duck6> ducks = Arrays.asList(
                new Duck6("Jerry", "yellow", 3),
                new Duck6("George", "brown", 4),
                new Duck6("Kramer", "mottled", 6),
                new Duck6("Elaine", "white", 2),
                new Duck6("Huey", "mottled", 2),
                new Duck6("Louie", "white", 4),
                new Duck6("Dewey", "brown", 6)
        );

        ducks.stream()
                .collect(Collectors.groupingBy(d -> d.getColor()))
                .forEach((c, dl) -> {
                    System.out.print("Ducks who are " + c + ": ");
                    dl.forEach(d -> System.out.print(d.getName() + " "));
                    System.out.println();
                });

        // What is the result?
        // A.   Compilation fails
        // B.   An exception is thrown at runtime
        // C.   {Ducks who are color:[Kramer, Huey], Ducks who are color:[Elaine, Louie ], Ducks who are color:[Jerry],
        //      Ducks who are color:[George, Dewey]
        // D.   Ducks who are mottled: Kramer Huey              --> CORRECT
        //      Ducks who are white: Elaine Louie
        //      Ducks who are yellow: Jerry
        //      Ducks who are brown: George Dewey
    }
}

class Duck6 implements Comparable<Duck6> {

    String name;
    String color;
    int age;

    public Duck6(String name, String color, int age) {
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
    public int compareTo(Duck6 duck) {
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