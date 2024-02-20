package Chapter6_Generics_and_Collections.Questions;

import java.util.ArrayList;
import java.util.List;

public class Question8 {
//    Given a method declared as:

    public static <E extends Number> List<E> process(List<E> nums) { return nums; }



    public static void main(String[] args) {
//        A programmer wants to use this method like this:

//      INSERT DECLARATIONS HERE

//        output = process(input);          // commented as won't compile
    }


//    Which pairs of declarations could be placed at // INSERT DECLARATIONS HERE
//    to allow the code to compile? (Choose all that apply)

//    A. ArrayList<Integer> input = null;       --> List is returned, ArrayList can't refer to List
//          ArrayList<Integer> output = null;
//    B. ArrayList<Integer> input = null;       --> CORRECT
//          List<Integer> output = null;
//    C. ArrayList<Integer> input = null;
//          List<Number> output = null;
//    D. List<Number> input = null;
//          ArrayList<Integer> output = null;
//    E. List<Number> input = null;             --> CORRECT
//          List<Number> output = null;
//    F. List<Integer> input = null;            --> CORRECT
//          List<Integer> output = null;
}
