package Chapter11_Concurrency.Parallel_Streams;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class ForEachOrderedExample {
    public static void main(String[] args) {
        List<Dog> dogs = new ArrayList<>();
        Dog aiko = new Dog("aiko", 10,1);
        Dog boi = new Dog("boi", 6,1);
        Dog charis = new Dog("charis", 7,1);
        Dog clover = new Dog("clover", 12,1);
        Dog zooey = new Dog("zooey", 8,1);
        dogs.add(aiko);
        dogs.add(boi);
        dogs.add(charis);
        dogs.add(clover);
        dogs.add(zooey);

        // ordered
        dogs.stream().filter(d -> d.getAge() > 7).forEach(System.out::println);

        // forEachOrdered - to make sure that a parallel stream gives us ordered results at expense of performance
        // would be different result every time otherwise
        dogs.stream().parallel().filter(d -> d.getAge() > 7).forEachOrdered(System.out::println);
        // we can do this because a List os ordered.
    }
}

class Dog {
    private String name;
    private int age;
    private int weight;

    public Dog(String name, int age, int weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void bark() {
        System.out.println("Woof!");
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                '}';
    }
}
