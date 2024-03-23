package Chapter11_Concurrency.Questions;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class Question1 {
    public static void main(String[] args) {
        CopyOnWriteArrayList<Integer> cowList = new CopyOnWriteArrayList<>();
        cowList.add(4);
        cowList.add(2);
        Iterator<Integer> it = cowList.iterator();
        cowList.add(6);
        while(it.hasNext()) {
            System.out.print(it.next() + " ");
        }
    }
}

// What is the result?

// A. 6
// B. 12
// C. 4 2               --> CORRECT
// D. 4 2 6
// E. Compilation fails
// F. An exception is thrown at runtime
