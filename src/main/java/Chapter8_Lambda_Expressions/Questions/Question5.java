package Chapter8_Lambda_Expressions.Questions;

import java.util.Arrays;
import java.util.List;

public class Question5 {

    public static void main(String[] args) {

        // Given the code fragment:

        List<Reading> readings = Arrays.asList(
                new Reading(2017, 1, 1, 405.91),
                new Reading(2017, 1, 8, 405.98),
                new Reading(2017, 1, 15, 406.14),
                new Reading(2017, 1, 22, 406.48),
                new Reading(2017, 1, 29, 406.20),
                new Reading(2017, 2, 5, 406.03)
        );

//        Which code fragment will sort the readings in ascending order by value and print the value of each reading?

//        readings.sort((r1, r2) -> r1.value < r2.value ? -1 : 1);
//        readings.forEach(System.out.println(r.value));

//        readings.sort((r1, r2) -> r1.value < r2.value ? 1 : -1);
//        readings.forEach(System.out.println(r.value));

//        readings.sort((r1, r2) -> r1.value < r2.value ? -1 : 1);
//        readings.forEach(System.out::println);

//        readings.sort((r1, r2) -> r1.value < r2.value ? -1 : 1);            //---> CORRECT
//        readings.forEach(r -> System.out.println(r.value));

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