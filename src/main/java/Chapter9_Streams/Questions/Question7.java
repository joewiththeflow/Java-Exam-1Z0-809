package Chapter9_Streams.Questions;

import java.util.Arrays;
import java.util.List;

public class Question7 {
    public static void main(String[] args) {

        List<Duck5> ducks = Arrays.asList(
                new Duck5("Jerry", "yellow", 3),
                new Duck5("George", "brown", 4),
                new Duck5("Kramer", "mottled", 6),
                new Duck5("Elaine", "white", 2),
                new Duck5("Huey", "mottled", 2),
                new Duck5("Louie", "white", 4),
                new Duck5("Dewey", "brown", 6)
        );

        // Which code fragment would you use to count how many mottled ducks there are?

        // A. long count = ducks.stream().filter(d -> d.getColor().equals("mottled")).count();  --> CORRECT
        // B. int count = ducks.stream().filter(d -> d.getColor().equals("mottled")).count();
        // C. long count = ducks.stream().filter(d -> d.equals("mottled")).count();
        // D. long count = ducks.stream().filter(Duck5::getColor().equals("mottled")).count();  // invalid syntax
    }
}

class Duck5 implements Comparable<Duck5> {

    String name;
    String color;
    int age;

    public Duck5(String name, String color, int age) {
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
    public int compareTo(Duck5 duck) {
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