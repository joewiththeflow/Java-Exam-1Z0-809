package Chapter9_Streams.Collecting_Values;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CollectExample {

    public static void main(String[] args) {

        Person beth = new Person("Beth", 30);
        Person eric = new Person("Eric", 31);
        Person deb = new Person("Deb", 31);
        Person liz = new Person("Liz", 30);
        Person wendi = new Person("Wendi", 34);
        Person kathy = new Person("Kathy", 35);
        Person bert = new Person("Bert", 32);
        Person bill = new Person("Bill", 34);
        Person robert = new Person("Robert", 38);

        List<Person> people = new ArrayList<>();
        people.add(beth);
        people.add(eric);
        people.add(deb);
        people.add(liz);
        people.add(wendi);
        people.add(kathy);
        people.add(bert);
        people.add(bill);
        people.add(robert);

        // Collect everyone who is 34 into a list
        List<Person> peopleAge34 =
                people.stream()
                        .filter(p -> p.getAge() == 34)
                        .collect(Collectors.toList());
        System.out.println("People aged 34: " + peopleAge34);

        // There's no guarantee what kind of List you will get using Collectors.toList()
        // If you specifically want an ArrayList:
        List<Person> peopleAge342 =
                people.stream()
                        .filter(p -> p.getAge() == 34)
                        .collect(Collectors.toCollection(ArrayList::new));
        System.out.println("People aged 34: " + peopleAge342);
    }
}

class Person {
    public String name;
    public Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
