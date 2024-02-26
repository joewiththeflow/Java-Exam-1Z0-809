package Chapter8_Lambda_Expressions.Questions;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Question10 {

    public static void main(String[] args) {

        BiFunction<Integer, String, String> foo = (n, s) -> {
            String newString = "";
            for (int i = 0; i < n; i++) {
                newString = s + " " + newString;
            }
            return newString;
        };

        Function<String, String> bar = (s) -> s + "bar";
        System.out.println(foo.andThen(bar).apply(3, "foo"));

//        What is the result?

//        A. foo foo foo bar bar bar
//        B. foo foo foo bar                --> CORRECT
//        C. foo foo foo
//        D. Compilation fails
    }
}
