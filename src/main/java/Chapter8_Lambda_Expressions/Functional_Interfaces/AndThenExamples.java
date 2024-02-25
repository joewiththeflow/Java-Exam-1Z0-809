package Chapter8_Lambda_Expressions.Functional_Interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class AndThenExamples {
    public static void main(String[] args) {

        List<Dog> dogs = new ArrayList<>();
        Dog boi = new Dog("boi", 6, 30);
        Dog clover = new Dog("clover", 12, 35);
        Dog zooey = new Dog("zooey", 8, 45);
        dogs.add(boi);
        dogs.add(clover);
        dogs.add(zooey);

        Consumer<Dog> displayName = d -> System.out.print(d + " ");
        dogs.forEach(displayName.andThen(d -> d.bark()));

        // You can't write inline lambdas for both
//        dogs.forEach((d -> System.out.print(d + " ")).andThen(d -> d.bark()));

        // You can use a named Consumer for both
        Consumer<Dog> doBark = d -> d.bark();
        dogs.forEach(displayName.andThen(doBark));

        // you can keep chaining
        dogs.forEach(displayName.andThen(doBark).andThen(doBark));
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
