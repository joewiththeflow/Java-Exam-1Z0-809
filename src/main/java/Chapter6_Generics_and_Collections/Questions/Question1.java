package Chapter6_Generics_and_Collections.Questions;

import java.util.ArrayList;
import java.util.List;

public class Question1 {
    public static void main(String[] args) {

        // INSERT DECLARATION HERE
        List<List<Integer>> table = new ArrayList<List<Integer>>();     // --using B. so this class compiles
        for(int i = 0; i <= 10; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < 10; j++) {
                row.add(i * j);
            }
            table.add(row);
        }

        for (List<Integer> row : table)
            System.out.println(row);
    }
}

// Which statements could be inserted at // INSERT DECLARATION HERE to allow this code to compile and run?
// Choose all that apply

// A. List<List<Integer>> table = new List<List<Integer>>();            // List is an interface, can't be new List
// B. List<List<Integer>> table = new ArrayList<List<Integer>>();       // CORRECT
// C. List<List<Integer>> table = new ArrayList<ArrayList<Integer>>();  // ArrayList is the type, but List is the type of row
                                                                        // which is added to table
// D. List<List, Integer> table = new List<List, Integer>();            // map
// E. List<List, Integer> table = new ArrayList<List, Integer>();       // map
// F. List<List, Integer> table = new ArrayList<ArrayList, Integer>();  // map
