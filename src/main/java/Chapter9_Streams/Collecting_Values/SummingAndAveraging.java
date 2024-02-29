package Chapter9_Streams.Collecting_Values;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SummingAndAveraging {

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

        // A contrived example to get the sum of the ages of people whose names begin with "B" and group by name:
        Map<String, Integer> sumOfBAges =
                people.stream()
                        .filter(p -> p.getName().startsWith("B"))
                        .collect(
                                Collectors.groupingBy(
                                        Person::getName,
                                        Collectors.summingInt(Person::getAge)   // sum of ages
                                )
                        );
        System.out.println("People by sum of age: " + sumOfBAges);

        // Produces:
        // People by sum of age: {Bill=74, Beth=75, Bert=70}


        // Get the average age of people whose names begin with "B"
        Map<String, Double> avgOfBAges =        // note we need Double, not Integer!
                people.stream()
                        .filter(p -> p.getName().startsWith("B"))
                        .collect(
                                Collectors.groupingBy(
                                        Person::getName,
                                        Collectors.averagingInt(Person::getAge)
                                )
                        );
        System.out.println("People by avg of age: " + avgOfBAges);

        // Produces:
        // People by avg of age: {Bill=37.0, Beth=37.5, Bert=35.0}
    }
}
