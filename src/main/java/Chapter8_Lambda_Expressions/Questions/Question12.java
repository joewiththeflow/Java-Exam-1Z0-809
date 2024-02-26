package Chapter8_Lambda_Expressions.Questions;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

public class Question12 {

    public static void main(String[] args) {
        Map<String, String> todos = new HashMap<>();
        todos.put("monday", "wash dog");
        todos.put("tuesday", "weed yard");
        // L1
        BiConsumer<String, String> printTodo = (String k, String v) -> System.out.println("On " + k + " do: " + v);
        todos.forEach(printTodo);

//        Which fragments inserted independently produce the to-do items, both key and value, in the Map?

//        A. Function<String, String> printTodo = (String k, String v) -> System.out.println("On " + k + " do: " + v);
//        B. Consumer<String, String> printTodo = (String k, String v) -> System.out.println("On " + k + " do: " + v);
//        C. Consumer<Map> printTodo = (Map m) -> System.out.println("On " + m.keySet() + " do: " + m.values());
//        D. BiConsumer<String, String> printTodo = (String k, String v) -> System.out.println("On " + k + " do: " + v); ---> CORRECT
    }
}
