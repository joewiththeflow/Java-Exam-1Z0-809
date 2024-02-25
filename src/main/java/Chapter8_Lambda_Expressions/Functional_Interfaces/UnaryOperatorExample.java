package Chapter8_Lambda_Expressions.Functional_Interfaces;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class UnaryOperatorExample {
    public static void main(String[] args) {
        // extends the Function interface so its functional method is apply()
        // However, it requires that the type of the argument to apply() be the same as the return value

        UnaryOperator<Double> log2 = v -> Math.log(v) / Math.log(2);
        System.out.println(log2.apply(8.0));

        // You could of course have done the following
        Function<Double, Double> log2ver2 = v -> Math.log(v) / Math.log(2);
        System.out.println(log2ver2.apply(8.0));
    }
}
