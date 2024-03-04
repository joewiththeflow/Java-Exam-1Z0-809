package Chapter9_Streams.Questions;


import java.util.Arrays;
import java.util.List;

public class Question4 {
    public static void main(String[] args) {

        List<Duck2> ducks = Arrays.asList(
           new Duck2("Jerry", "yellow", 3),
           new Duck2("George", "brown", 4),
           new Duck2("Kramer", "mottled", 6),
           new Duck2("Elaine", "white", 2),
           new Duck2("Huey", "mottled", 2),
           new Duck2("Louie", "white", 4),
           new Duck2("Dewey", "brown", 6)
        );

        // Which code fragemnt could you use for CODE in the call to map() in the following code fragment?

        System.out.println("Duck names: ");
        //ducks.stream().map(CODE).forEach(d -> System.out.print(d + " " );
        System.out.println();

        // to correctly print the String:

        // Duck names: Jerry, George, Kramer, Elaine, Huey, Louie, Dewey

        // A. Duck::getName         --> CORRECT (method reference for: d -> d.getName())
        // B. d::d.getName()
        // C. d -> d.getName()      --> CORRECT
        // D. d.getName()
    }
}

class Duck2 implements Comparable<Duck2> {

    String name;
    String color;
    int age;

    public Duck2(String name, String color, int age) {
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
    public int compareTo(Duck2 duck) {
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

