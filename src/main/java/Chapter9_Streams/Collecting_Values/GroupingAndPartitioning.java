package Chapter9_Streams.Collecting_Values;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingAndPartitioning {
    public static void main(String[] args) {

        // We can group people by age using the Collectors.groupingBy() method
        // We specify how to group Person objects by passing a Function to the method, which will return a Collector
        // that will collect data elements from the stream and group them in a Map by a key according to that Function

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

        Map<Integer, List<Person>> peopleByAge =
        people.stream()
                .collect(Collectors.groupingBy(Person::getAge));
        System.out.println("People by age " + peopleByAge);

        // Produces:
        // People by age {32=[Person{name='Bert', age=32}],
        // 34=[Person{name='Wendi', age=34}, Person{name='Bill', age=34}],
        // 35=[Person{name='Kathy', age=35}],
        // 38=[Person{name='Robert', age=38}],
        // 30=[Person{name='Beth', age=30}, Person{name='Liz', age=30}],
        // 31=[Person{name='Eric', age=31}, Person{name='Deb', age=31}]}


        // The groupingBy() method is heavily overloaded with a variety of options for grouping values in a Collection
        // For example, we can pass a Collector as the second parameter, allowing you reduce the List further
        Map<Integer, Long> numPeopleWithAge =
                people.stream()
                        .collect(Collectors.groupingBy(
                                Person::getAge,
                                Collectors.counting()           // returns a Long
                        ));
        System.out.println("People by age: " + numPeopleWithAge);

        // Produces:
        // People by age: {32=1, 34=2, 35=1, 38=1, 30=2, 31=2}


        // We can also create a Map of ages to a list of names for that age rather than Person objects
        Map<Integer, List<String>> namesByAge =
                people.stream()
                        .collect(
                                Collectors.groupingBy(
                                        Person::getAge,
                                        Collectors.mapping(
                                                Person::getName,
                                                Collectors.toList()
                                        )
                                )
                        );
        System.out.println("People by age: " + namesByAge);

        // Produces:
        // People by age: {32=[Bert], 34=[Wendi, Bill], 35=[Kathy], 38=[Robert], 30=[Beth, Liz], 31=[Eric, Deb]}



        // Partitioning as you collect is essentially a more specialised kind of groupingBy()
        // The partitioningBy() method organises the results into a Map like groupingBy() does, but partitioningBy()
        // takes a Predicate rather than a Function, so the results are split into two groups (partitions) based on
        // whether the items in the stream pass the test in the Predicate
        // For example, is the person older than 34?
        Map<Boolean, List<Person>> peopleOlderThan34 =
                people.stream()
                        .collect(Collectors.partitioningBy(
                                p -> p.getAge() > 34
                        ));
        System.out.println("People > 34: " + peopleOlderThan34);

        // Produces:
        // People > 34:
        // {false=[Person{name='Beth', age=30}, Person{name='Eric', age=31}, Person{name='Deb', age=31},
        // Person{name='Liz', age=30}, Person{name='Wendi', age=34}, Person{name='Bert', age=32},
        // Person{name='Bill', age=34}],
        // true=[Person{name='Kathy', age=35}, Person{name='Robert', age=38}]}
    }
}
