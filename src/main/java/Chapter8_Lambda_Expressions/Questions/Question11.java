package Chapter8_Lambda_Expressions.Questions;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Question11 {

    public static void main(String[] args) {

        List<String> trees = Arrays.asList("FIR", "CEDAR", "PINE");
        //L1

//        trees.replaceAll(convert);
//        trees.forEach(t -> System.out.print(t + " "));

//        Which fragments inserted independently at // L1 produce the output:
//          fir cedar pine

//        A. UnaryOperator<String> convert = (t) -> t.toLowerCase();        --> CORRECT
//        B. UnaryOperator<String, String> convert = (t) -> t.toLowerCase();
//        C. Function<String, String> convert = (t) -> t.toLowerCase();     --> replaceAll() takes a UnaryOperator ONLY
                                                                            // probably to ensure you replace with the same type
//        D. Supplier<String> convert = (t) -> t.toLowerCase();
    }
}
