package Chapter8_Lambda_Expressions.Questions;

public class Question2 {

    // Which of the following expressions are legal?

//  A.  FtoC converter = (f) -> (f - 32.0) * 5/9;               --> CORRECT
//  B.  FtoC converter2 = f -> (f - 32.0) * 5/9;                --> CORRECT
//  C.  FtoC converter3 = f -> return (f - 32.0) * 5/9;
//  D.  double converter4 = f -> (f - 32.0) * 5/9;
//  E.  FtoC converter5 = f -> { return (f - 32.0) * 5/9; };    --> CORRECT
}

@FunctionalInterface
interface FtoC {
    double convert(double f);
}
