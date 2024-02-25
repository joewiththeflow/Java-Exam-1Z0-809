package Chapter8_Lambda_Expressions.Functional_Interfaces;

import java.util.Map;
import java.util.Random;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

public class SupplierExample {

    public static void main(String[] args) {

        Supplier<Integer> answerSupplier = () -> 42;
        System.out.println("Answer to everything: " + answerSupplier.get());

        // We could also use an nner class rather than a lambda:
        Supplier<Integer> answerSupplier2 = new Supplier<Integer>() {
            @Override
            public Integer get() {
                return 42;
            }
        };
        System.out.println("Answer to everything: " + answerSupplier2.get());

        Supplier<String> userSupplier = () -> {
            Map<String, String> env = System.getenv();          // get the system environment map
            return env.get("USER");                             // get the value with the key "USER" from the map and
                                                                // return it (for Windows the key is "USERNAME"
        };
        System.out.println("User is: " + userSupplier.get());


        // There are a few different Suppliers that return primitives instead of objects to avoid unboxing
        // These interfaces have a a getAsxxx() method rather than get() - need to remember for exam
        // e.g.
        Random random = new Random();
        IntSupplier randomIntSupplier = () -> random.nextInt(50);
        int myRandom = randomIntSupplier.getAsInt();                        // .getAsInt()
        System.out.println("Random number: " + myRandom);
    }
}
