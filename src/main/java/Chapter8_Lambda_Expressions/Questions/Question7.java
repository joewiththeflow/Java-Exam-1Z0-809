package Chapter8_Lambda_Expressions.Questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Question7 {

    public static void main(String[] args) {

        Human jenny = new Human(18, "Jenny");
        Human jeff = new Human(17, "Jeff");
        Human jill = new Human(21, "Jill");

        List<Human> people = new ArrayList<>(Arrays.asList(jenny, jeff, jill));
        // L1
//        people.forEach(printAdults);

//        Which fragment inserted at L1 will print the names of only adults (those humans whose age is older than 17)?

//      A. Predicate<Human> printAdults = p -> { if (p.getAge() >= 18) {
//            System.out.println(p.name);
//        }};

//      B. Predicate<Human> adult = p -> p.getAge() >= 18;
//        Consumer<Human> printAdults = p -> { if (p.getAge(adult.test()) >= 18) {
//            System.out.println(p.name);
//        }};

//      C. Predicate<Human> adult = p -> p.getAge() >= 18;                          //---> CORRECT
//        Consumer<Human> printAdults = p -> { if (adult.test(p)) {
//            System.out.println(p.name);
//        }};

//      D. Consumer printAdults(Human p) {
//            if (p.getAge() >= 18) {
//                System.out.println(p.name);
//            }
//        };
    }
}
