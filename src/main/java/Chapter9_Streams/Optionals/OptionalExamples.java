package Chapter9_Streams.Optionals;

import Chapter8_Lambda_Expressions.Syntax.Dog;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Stream;

public class OptionalExamples {

    public static void main(String[] args) {

        Stream<Double> doubleStream =
                Stream.of(1.0, 2.0, 3.0, 4.0);
        Optional<Double> aNum = doubleStream.findFirst();       // Note that this is Optional<Double> not OptionalDouble
        if (aNum.isPresent()) {
            System.out.println("First number from the doubles stream: " + aNum.get());
        } else {
            System.out.println("Doubles stream is empty!");
        }

        // Another way to see if an optional contains a value is to use ifPresent() which takes a Consumer

        Stream<Double> doubleStream2 =
                Stream.of(1.0, 2.0, 3.0, 4.0);
        Optional<Double> anum2 = doubleStream2.findFirst();
        anum2.ifPresent(n -> System.out.println("First number from the doubles stream: " + n));

        // Note above that n is actually a Double, not an Optional<Double>, so we can just
        // print n rather than n.get()


        // You can create your own optionals
        Dog boi = new Dog("boi", 30, 6);
        Optional<Dog> optionalBoi = Optional.of(boi);
        optionalBoi.ifPresent(System.out::println);

        // But what happen if Boi is null? Null Pointer exception
//        boi = null;
//        Optional<Dog> optionalBoi2 = Optional.of(boi);
//        optionalBoi2.ifPresent(System.out::println);

        // instead you have to use the Optional.ofNullable() method which creates the optional if the object you pass
        // in is not null; otherwise it creates an empty optional
        boi = null;
        Optional<Dog> optionalBoi3 = Optional.ofNullable(boi);
        optionalBoi3.ifPresent(System.out::println);
        if (!optionalBoi3.isPresent()) System.out.println("Boi must be null");


        // You can also create empty optionals directly
        Optional<Dog> emptyDog = Optional.empty();
        if (!emptyDog.isPresent()) {
            System.out.println("Empty dog must be empty");
        }
        List<Dog> dogs = Arrays.asList(
                new Dog("Boi", 30, 6),
                new Dog("Zooey", 12, 8),
                new Dog("Charis", 33, 4));
        emptyDog = dogs.stream().findFirst();
        emptyDog.ifPresent(d -> System.out.println("Empty dog is no longer empty"));

        // Another way to handle an empty optional is the orElse() method
        // You get the value of the optional or, if it empty, you get the value you specify in the orElse() method
        Optional<Dog> emptyDog2 = Optional.empty();
        Dog aDog = emptyDog2.orElse(new Dog("Default Dog", 50, 10));
        System.out.println("A Dog: " + aDog);

        // If it wasn't empty, the output would be different:
        Optional<Dog> optionalBoi4 = Optional.of(new Dog("Boi", 30, 6));
        Dog aDog2 = optionalBoi4.orElse(new Dog("Default Dog", 50, 10));
        System.out.println("A Dog: " + aDog2);
    }
}
