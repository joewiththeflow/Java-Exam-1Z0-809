package Chapter8_Lambda_Expressions.Questions;

import com.sun.xml.internal.bind.util.Which;

import java.util.function.DoubleSupplier;

public class Question14 {

    public static void main(String[] args) {

        DoubleSupplier d = () -> 42.0;
        // L1


//        Which fragments inserted independently at // L1 produce the output:
//              The answer is: 42.0

//        A. System.out.println("The answer is: " + d.get());
//        B. double answer = d.getAsDouble();                               --> CORRECT
//           System.out.println("The answer is: " + answer);
//        C. System.out.println("The answer is: " + d.getAsDouble());       --> CORRECT
//        D. double answer = d.get();
//           System.out.println("The answer is: " + answer);
    }
}
