package Chapter9_Streams.Collecting_Values;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CountingJoiningMaxByMinBy {
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
        Person bill2 = new Person("Bill", 40);
        Person beth2 = new Person("Beth", 45);
        Person bert2 = new Person("Bert", 38);

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
        people.add(bill2);
        people.add(beth2);
        people.add(bert2);

        // You can count objects using the Collectors.counting() method, but you would be better just using Stream.count()
        Long n = people.stream().collect(Collectors.counting());
        Long n2 = people.stream().count();
        System.out.println("First count: " + n + " and second count: " + n2);

        //Produces:
        // First count: 12 and second count: 12

        // The Collectors.joining() method returns a Collector that takes Stream elements and concatenates them into a
        // String by order in which they are encountered (this may/may not be the same order of the original Collection
        // e.g. the name of every Person who's older than 34:
        String older34 =
                people.stream()
                        .filter(p -> p.getAge() > 34)
                        .map(p -> p.getName())
                        .collect(
                                Collectors.joining(", ")
                        );
        System.out.println("Names of people older than 34: " + older34);

        // Produces:
        // Names of people older than 34: Kathy, Robert, Bill, Beth, Bert


        // maxBy()
        Optional<Person> oldest =
                people.stream()
                        .collect(Collectors.maxBy((p1, p2) -> p1.getAge() - p2.getAge()));  // Comparator
        oldest.ifPresent(p -> System.out.println("Oldest person: " + p));

        // Produces:
        // Oldest person: Person{name='Beth', age=45}


        // minBy()
        Optional<Person> youngest =
                people.stream()
                        .collect(Collectors.minBy((p1, p2) -> p1.getAge() - p2.getAge()));  // Comparator
        youngest.ifPresent(p -> System.out.println("Youngest person: " + p));

        // Produces:
        // Youngest person: Person{name='Beth', age=30}


        // The advantage of using maxBy() is that we get the whole Person object back
        // If we used Stream.max() we would just get the age back
        System.out.println(people.stream().mapToInt(p -> p.getAge()).max());

        // Produces:
        // OptionalInt[45]

        // It is actually possible to use max() with a comparator to do the same thing though
        System.out.println(people.stream().max((p1, p2) -> p1.getAge() - p2.getAge()));

        // Produces:
        // Optional[Person{name='Beth', age=45}]
    }
}
