package Chapter9_Streams.Questions;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class Question6 {

    public static void main(String[] args) {

        List<Duck4> ducks = Arrays.asList(
                new Duck4("Jerry", "yellow", 3),
                new Duck4("George", "brown", 4),
                new Duck4("Kramer", "mottled", 6),
                new Duck4("Elaine", "white", 2),
                new Duck4("Huey", "mottled", 2),
                new Duck4("Louie", "white", 4),
                new Duck4("Dewey", "brown", 6)
        );

        // Which code fragment would you use to compute the average age of the ducks as a whole number?

        // A. double avgAge =
        //        ducks.stream().mapToInt(d -> d.getAge()).average();
        // B. OptionalDouble avgAge =                                       --> CORRECT
        //        ducks.stream().mapToInt(d -> d.getAge()).average();
        // C. Double avgAge =
        //        ducks.stream().mapToDouble(d -> d.getAge()).average();
        // D. double avgAge =
        //        ducks.stream().map(d -> d.getAge()).average();
    }
}

class Duck4 implements Comparable<Duck4> {

    String name;
    String color;
    int age;

    public Duck4(String name, String color, int age) {
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
    public int compareTo(Duck4 duck) {
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