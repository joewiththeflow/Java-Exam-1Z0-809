package Chapter9_Streams.Questions;

import java.util.Arrays;
import java.util.List;

public class Question5 {

    public static void main(String[] args) {

        List<Duck3> ducks = Arrays.asList(
                new Duck3("Jerry", "yellow", 3),
                new Duck3("George", "brown", 4),
                new Duck3("Kramer", "mottled", 6),
                new Duck3("Elaine", "white", 2),
                new Duck3("Huey", "mottled", 2),
                new Duck3("Louie", "white", 4),
                new Duck3("Dewey", "brown", 6)
        );

        // What output does the following fragment produce?

        ducks.stream()
                .filter(d -> d.getColor().equals("mottled"))
                .map(d -> d.getName())
                .forEach(d -> System.out.print(d + " "));

        // A. Kramer Huey                               --> CORRECT
        // B. Jerry George Kramer Elaine Huey Louie Dewey
        // C. No output, the code does not compile
        // D. Kramer is mottled and is 6 years old. Huey is mottled and is 2 years old.
    }
}


class Duck3 implements Comparable<Duck3> {

    String name;
    String color;
    int age;

    public Duck3(String name, String color, int age) {
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
    public int compareTo(Duck3 duck) {
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