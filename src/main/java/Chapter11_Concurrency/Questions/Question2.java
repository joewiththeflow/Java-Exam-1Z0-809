package Chapter11_Concurrency.Questions;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class Question2 {
    public static void main(String[] args) {
        CopyOnWriteArrayList<Integer> cowList = new CopyOnWriteArrayList<>();
        cowList.add(4);
        cowList.add(2);
        cowList.add(6);
        Iterator<Integer> it = cowList.iterator();
        cowList.remove(2);
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
    }
}

// What is the result?

// A. 12
// B. 10
// C. 4 2 6                     --> CORRECT
// D. 4 6
// E. Compilation fails
// F. An exception is thrown at runtime
