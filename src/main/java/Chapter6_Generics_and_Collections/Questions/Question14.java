package Chapter6_Generics_and_Collections.Questions;

import java.util.SortedMap;
import java.util.TreeMap;

public class Question14 {
    public static void main(String[] args) {
        TreeMap<String, String> myMap = new TreeMap<>();
        myMap.put("a", "apple"); myMap.put("d", "date");
        myMap.put("f", "fig"); myMap.put("p", "pear");
        System.out.println("1st after mango: " +        // sop 1
                myMap.higherKey("f"));
        System.out.println("!st after mango: " +        // sop 2
                myMap.ceilingKey("f"));
        System.out.println("1st after mango: " +        // sop 3
                myMap.floorKey("f"));
        SortedMap<String, String> sub = new TreeMap<>();
        sub = myMap.tailMap("f");
        System.out.println("1st after mango: " +        // sop 4
                sub.firstKey() );
    }
}

// Which of the System.out.println statements will produce the output "1st after mango: p"? (Choose all that apply)

// A. sop 1         --> CORRECT
// B. sop 2
// C. sop 3
// D. None, compilation fails
// E. None, an exxception is thrown at runtime
