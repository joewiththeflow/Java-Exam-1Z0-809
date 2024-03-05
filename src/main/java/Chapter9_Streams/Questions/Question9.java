package Chapter9_Streams.Questions;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Question9 {

    public static void main(String[] args) {
        List<Duck7> ducks = Arrays.asList(
                new Duck7("Jerry", "yellow", 3),
                new Duck7("George", "brown", 4),
                new Duck7("Kramer", "mottled", 6),
                new Duck7("Elaine", "white", 2),
                new Duck7("Huey", "mottled", 2),
                new Duck7("Louie", "white", 4),
                new Duck7("Dewey", "brown", 6)
        );

        // What is the correct TYPE in the following code fragment?

        // TYPE duckMap =
                ducks.stream()
                        .collect(Collectors.groupingBy(d -> d.getColor(), Collectors.toList()));

        // A. Map<String, Duck>
        // B. List<Duck>
        // C. Map<String, List<Duck>>       --> CORRECT
        // D. Map<List<Duck>, String>
    }
}

class Duck7 implements Comparable<Duck7> {

    String name;
    String color;
    int age;

    public Duck7(String name, String color, int age) {
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
    public int compareTo(Duck7 duck) {
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