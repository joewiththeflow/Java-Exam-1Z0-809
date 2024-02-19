package Chapter6_Generics_and_Collections.Questions;

import java.util.HashMap;
import java.util.Map;

public class Question4 {
    public static void main(String[] args) {
        Map<ToDos, String> m = new HashMap<>();
        ToDos t1 = new ToDos("Monday");
        ToDos t2 = new ToDos("Monday");
        ToDos t3 = new ToDos("Tuesday");
        m.put(t1, "doLaundry");
        m.put(t2, "payBills");
        m.put(t3, "cleanAttic");
        System.out.println(m.size());
    }
}

class ToDos {
    String day;
    ToDos(String d) { day = d; }

    @Override
    public boolean equals(Object obj) {
        return ((ToDos)obj).day.equals(this.day);
    }
     // public int hashCode() { return 9; }
}

// Which is correct? (Choose all that apply)

// A. As the code stands, it will not compile
// B. As the code stands, the output will be 2
// C. As the code stands, the output will be 3                          --> CORRECT, 3 entries are added to the HashMap
                                                                        // as the default hashCode() method from object
                                                                        // means each ToDos("Monday"), although equal, is
                                                                        // put in a different bucket. Therefore when the
                                                                        // second ToDos("Monday") is added, the HashMap
                                                                        // will calculate a different hashCode, which means
                                                                        // it will look in a different bucket and therefore
                                                                        // will not be able to find the existing ToDos("Monday")
                                                                        // This means it will add another ToDos("Monday")
                                                                        // instead of realising the key already exists
// D. If the hashCode() method is uncommented, the output will be 2     --> CORRECT, when the hashCode() is overridden and returns
                                                                        // the same value for the second ToDos("Monday"), the
                                                                        // HashMap finds the existing key in the correct bucket
                                                                        // and using equals() realises this key already exists,
                                                                        // so the second put statement actually updates the existing key
// E. If the hashCode() method is uncommented, the output will be 3
// F. If the hashCode() method is uncommented, the code will not compile
