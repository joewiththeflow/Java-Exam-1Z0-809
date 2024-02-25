package Chapter8_Lambda_Expressions.Functional_Interfaces;

import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ConsumerExample {

    public static void main(String[] args) {

        Consumer<String> redOrBlue = pill -> {
            if (pill.equals("red")) {
                System.out.println("Down the rabbit hole");
            } else if (pill.equals("blue")) {
                System.out.println("Stay in lala land");
            }
        };

        redOrBlue.accept("red");

        // There are also Consumers for primitives e.g. IntConsumer, DoubleConsumer, LongConsumer etc.
        // Their accept method takes one primitive and avoid autoboxing

        // There are also ObjIntConsumer, ObjDoubleConsumer and ObjLongConsumer whose accept method takes an Object of type
        // T and an int, a double or a long respectively

        // There's also the BiConsumer whose accept method can take two objects
        Map<String, String> env = System.getenv();
        BiConsumer<String, String> printEnv = (key, value) -> {
            System.out.println(key + ": " + value);
        };
        printEnv.accept("USER", env.get("USER"));
    }



}
