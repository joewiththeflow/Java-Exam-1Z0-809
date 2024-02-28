package Chapter9_Streams.Map_Filter_Reduce_Optionals;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class AssociativeAccumulations {

    public static void main(String[] args) {

        List<Reading> readings = Arrays.asList(
                new Reading(2017, 1, 1, 405.91),
                new Reading(2017, 1, 8, 405.98),
                new Reading(2017, 1, 15, 406.14),
                new Reading(2017, 1, 22, 406.48),
                new Reading(2017, 1, 29, 406.20),
                new Reading(2017, 2, 5, 407.12),
                new Reading(2017, 2, 12, 406.03)
        );

        // You could try writing the following code to write your own reduce() for average

        OptionalDouble avgWithReduce =
                readings.stream()
                        .mapToDouble(r -> r.value)
                        .filter(v -> v >= 406.00 && v < 407.00)
                        .reduce((v1, v2) -> (v1 + v2) / 2);
        if (avgWithReduce.isPresent()) {
            System.out.println("Average of 406 readings: " + avgWithReduce.getAsDouble());
        } else {
            System.out.println("Empty optional!");
        }

        // However, average is NOT ASSOCIATIVE!!!

        // The average of 1, 2 and 3 is 2

        // However what we are trying to do here is
        // average of 1 and 2 = 1.5
        // average of 1.5 and 3 = 2.25
        // and
        // average of 2 and 3 = 2.5
        // average of 2.5 and 1 = 1.75

        // average is clearly not associative and therefore we must use the average() function provided
    }
}
