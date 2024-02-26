package Chapter8_Lambda_Expressions.Questions;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Question4 {

    public static void main(String[] args) {
        // Given the following fragment:

//        System.out.format("Total = %.2f", computeTax(10.00, (p) -> p * 0.05));



    }
//    A. double computeTax(double price, Function<Double> op) {
//            return op.apply(price) + price;
//        }

//    B. double computeTax(double price, UnaryOperator<Double> op) {         //--> CORRECT
//        return op.apply(price) + price;
//    }

//    C. double computeTax(double price, double op) {
//        return op.apply(price) + price;
//    }

//    D. Function<Double, Double> computeTax(double price, UnaryOperator<Double> op) {
//        return op.apply(price) + price;
//    }
}
