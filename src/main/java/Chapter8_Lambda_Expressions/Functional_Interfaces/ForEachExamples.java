package Chapter8_Lambda_Expressions.Functional_Interfaces;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ForEachExamples {

    public static void main(String[] args) {
        // forEach() actually expects a consumer

        List<String> dogNames = Arrays.asList("boi", "clover", "zooey");
        Consumer<String> printName = name -> System.out.println(name);      // implement the accept method
        dogNames.forEach(printName);

        // But we could combine two lines into one
        dogNames.forEach(name -> System.out.println(name));


        // For a Map you would forEach will take a BiConsumer
        Map<String, String> env = System.getenv();
        BiConsumer<String, String> printEnv = (key, value) -> {
            System.out.println(key + ": " + value);
        };
        env.forEach(printEnv);  // forEach() method of Map expects a BiConsumer


        // We already know that we can't modify a variable in a lambda
//        String username;
//        BiConsumer<String, String> findUserName = (key, value) -> {
//            if (key.equals("USER")) username = value;       // Compiler error. username must be effectively final
//        };
//        env.forEach(findUserName);


        // We can modify the field of an object within a lambda however
        // This will however be less efficient than a for loop iteration and breaking out once the value is found
        // You may not need to do this but this just shows that you can
        // There is a better way in the Streams chapter to extract and collect values that doesn't rely on side effects
        User user = new User();
        BiConsumer<String, String> findUserName = (key, value) -> {
            if (key.equals("USER")) user.setUsername(value);
        };
        env.forEach(findUserName);
        System.out.println("Username from env: " + user.getUsername());
    }
}

class User {
    String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
