package Chapter9_Streams.Map_Filter_Reduce_Optionals;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class MapFilterReduceExample {

    public static void main(String[] args) {
        // Imagine you have a piece of equipment that takes a reading once a week and you want to find the average
        // You know the readings are probably between 406 and 407 so you decide to throw any other readings away as these
        // may be errors

        List<Reading> readings = Arrays.asList(
                new Reading(2017, 1, 1, 405.91),
                new Reading(2017, 1, 8, 405.98),
                new Reading(2017, 1, 15, 406.14),
                new Reading(2017, 1, 22, 406.48),
                new Reading(2017, 1, 29, 406.20),
                new Reading(2017, 2, 5, 407.12),
                new Reading(2017, 2, 12, 406.03)
        );

        // We'll need to use Map's mapToDouble() method as map() would expect an Object whereas we have doubles
        // mapToDouble() will return a DoubleStream, not a Stream<Double> ---> VERY IMPORTANT!!!!
        // We need a OptionalDouble because there may not be a value due to empty list or as a result of the filters
        OptionalDouble avg =
                readings.stream()
                        .mapToDouble(r -> r.value)                  // we have doubles, not Doubles, and this returns a DoubleStream
                        .filter(v -> v >= 406.0 && v < 407)
                        .average();                                 // a method of DoubleStream, not available in Stream<Double>

        // avg could be empty due to empty list of as part of filtering so we must check if it is empty first
        if(avg.isPresent()) {
            System.out.println("Average of 406 readings: " + avg.getAsDouble());
        } else {
            System.out.println("Empty optional");
        }
    }






}

class Reading {
    int year;
    int month;
    int day;
    double value;

    public Reading(int year, int month, int day, double value) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.value = value;
    }
}