package Chapter6_Generics_and_Collections.Generic_Types;

import java.util.ArrayList;
import java.util.List;

public class UnboxingGotcha {
    // With pre Java 5 code, you couldn't specify the type of a collection
    // As you couldn't specify the type, you couldn't be sure of what type you would get back from a collection
    // For that reason, when getting an item from a list without a type defined, you will get back an Object
    // Therefore you need to cast it to the type you expect

    public static void main(String[] args) {
        // Pre Java 5 code
        List test = new ArrayList();
        test.add(43);                       // You could actually add anything here eg:
        test.add("clown");
        test.add(new Float(2.13));
        int x = (Integer) test.get(0);      // But you MUST cast!

        // Java 5 and onwards
        List<Integer> test2 = new ArrayList<>();
        test2.add(43);
//        test2.add("clown");               // You can't add just anything
//        test2.add(new Float(2.13));
        int x2 = test2.get(0);              // No need to cast
    }
}
