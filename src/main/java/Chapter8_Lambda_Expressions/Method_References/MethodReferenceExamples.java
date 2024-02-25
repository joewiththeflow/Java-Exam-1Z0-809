package Chapter8_Lambda_Expressions.Method_References;

import java.util.Arrays;
import java.util.List;

public class MethodReferenceExamples {
    public static void main(String[] args) {

        // Sometimes the only thing a lambda expression does is call another method
        List<String> trees = Arrays.asList("fir", "cedar", "pine");
        trees.forEach(t -> System.out.println(t));

        // instance method reference
        trees.forEach(System.out::println);

        // use your own static method reference
        trees.forEach(MethodReferenceExamples::printTreeStatic);
    }

    public static void printTreeStatic(String t) {
        System.out.println("Tree name: " + t);
    }


}
