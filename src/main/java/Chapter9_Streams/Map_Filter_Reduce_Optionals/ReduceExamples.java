package Chapter9_Streams.Map_Filter_Reduce_Optionals;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

public class ReduceExamples {

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

        // The count() method is defined for both Stream and primitive versions of Stream
        // average() is only defined for the primitive versions
        // Other handy methods defined on primitive streams include min(), max() and sum()

        // max()

        OptionalDouble max =
                readings.stream()
                        .mapToDouble(r -> r.value)
                        .max();

        if (max.isPresent()) {
            System.out.println("Max of all readings: " + max.getAsDouble());
        } else {
            System.out.println("Empy optional!");
        }

        // min() and max() also produce Optionals, but sum() does not
        // DoubleStream.sum() returns a double
        // sum() assumes an empty list will be 0.0

        List<Reading> readings2 = Arrays.asList();                  // empty list
        double sum = readings2.stream().mapToDouble(r -> r.value).sum();
        System.out.println("Sum of all readings: " + sum);


        // Try your own reduce() instead of using (sum)
        // The type signature of DoubleStream.reduce() is:
                // OptionalDouble reduce(DoubleBinaryOperator op)

        // DoubleBinaryOperator is like a UnaryOperator, but the functional method takes in 2 args rather than one
        // The supplied args and the return value must be the same type

        // A DoubleBinaryOperator is an operator whose functional method, applyAsDouble(), takes two double values and
        // returns a double

        // Note that reduce() has to return an Optional

        OptionalDouble sum2 =
                readings.stream()
                        .mapToDouble(r -> r.value)
                        .reduce((v1, v2) -> v1 + v2);
        if(sum2.isPresent()) {
            System.out.println("sum of all readings: " + sum2.getAsDouble());
        }

        // There is another version of reduce() which takes an identity parameter:
            // double reduce(double identity, DoubleBinaryOperator op)

        // identity provides an initial value and something to return if the stream is empty
        // so in our example above, we could provide an identity of 0.0 since that makes sense for a sum
        // Note that as we will now always get a double back, we no longer have to use OptionalDouble

        double sum3 =
                readings.stream()
                        .mapToDouble(r -> r.value)
                        .reduce(0.0, (v1, v2) -> v1 + v2);

        System.out.println("sum of all readings: " + sum3);


    }
}
