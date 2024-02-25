package Chapter8_Lambda_Expressions.Functional_Interfaces;

import apple.laf.JRSUIUtils;

import java.util.Map;
import java.util.TreeMap;
import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionExamples {

    public static void main(String[] args) {

        // turn an Integer into a String
        Function<Integer, String> answer = a -> {
            if (a == 42) return "forty-two";
            else return "No answer for you!";
        };
        System.out.println(answer.apply(42));
        System.out.println(answer.apply(64));

        // BiFunction is similar but takes two arguments before returning a value
        BiFunction<String, String, String> firstLast = (first, last) -> first + " " + last;
        System.out.println("First and last name: " + firstLast.apply("Joe", "Smith"));


        // Let's use both a Function and a BiFunction in an example using Map methods
        Map<String, String> aprilWinner = new TreeMap<>();
        aprilWinner.put("April 2017", "Bob");
        aprilWinner.put("April 2016", "Annette");
        aprilWinner.put("April 2015", "Lamar");

        System.out.println("--- List, before checking April 2014 ---");
        aprilWinner.forEach((k, v) -> System.out.println(k + ": " + v));

        // no key for April 2014, so John Doe gets added to the map
        aprilWinner.computeIfAbsent("April 2014", (k) -> "John Doe");

        // key April 2014 now has a value, so Jane Doe won't be added
        aprilWinner.computeIfAbsent("April 2014", (k) -> "Jane Doe");

        System.out.println("--- List after checking April 2014 ---");
        aprilWinner.forEach((k, v) -> System.out.println(k + ": " + v));

        // use a BiFunction to replace all values in the map with uppercase values
        aprilWinner.replaceAll((key, oldValue) -> oldValue.toUpperCase());
        System.out.println("--- List after replacing values with uppercase ---");

        aprilWinner.forEach((k, v) -> System.out.println(k + ": " + v));


        // You can also use primitive types in the arguments e.g. DoubleFunction

        // There are also a lot of variations similar to IntToDoubleFunction
        // The functional method with these is different e.g. applyAsDouble()
        // This will take an int and return a double avoiding unnecessary autoboxing
    }
}
