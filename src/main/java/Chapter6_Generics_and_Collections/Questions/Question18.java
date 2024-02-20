package Chapter6_Generics_and_Collections.Questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
class Dog4 {
    String name;
    int weight;
    int age;

    public Dog4(String name, int weight, int age) {
        this.name = name;
        this.weight = weight;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Dog4{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", age=" + age +
                '}';
    }
}
class DogSort implements Comparator<Dog4> {
    @Override
    public int compare(Dog4 o1, Dog4 o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
public class Question18 {
    public static void main(String[] args) {
        Dog4 boi = new Dog4("boi", 30, 6);
        Dog4 clover = new Dog4("clover", 35, 12);
        Dog4 zooey = new Dog4("zooey", 45, 8);
        ArrayList<Dog4> dogs = new ArrayList<>(Arrays.asList(zooey, clover, boi));
        // INSERT HERE
        System.out.println(dogs);
    }
}

// Which of the following code fragments sorts the dogs in ascending order by name? (Choose all that apply)

// A. DogSort dogSorter = new DogSort();                                        --> CORRECT
//      dogs.sort(dogSorter);
// B. dogs.sort((d1, d2) -> d1.getName().compareTo(d2.getName()));              --> CORRECT
// C. dogs.sort(DogSort);
// D. dogs.sort(int compare(d1, d2) -> d1.getName().compareTo(d2.getName()));
// E. dogs.sort((d1, d2) -> d2,getName().compareTo(d1.getName()));
