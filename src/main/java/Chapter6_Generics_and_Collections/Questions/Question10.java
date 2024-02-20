package Chapter6_Generics_and_Collections.Questions;

import java.util.ArrayDeque;

public class Question10 {
    public static void main(String[] args) {
        ArrayDeque<String> ad = new ArrayDeque<>();
        ad.add("2");
        ad.add("4");
        System.out.print(ad.peek() + " ");
        ad.offer("1");
        ad.add("3");
        ad.remove();
        System.out.print(ad.poll() + " ");
        if (ad.peek().equals("2")) System.out.print(ad.poll() + " ");
        System.out.println(ad.poll() + " " + ad.peek());

    }
}

// A. 2 2 3 3
// B. 2 2 3 4
// C. 4 3 3 4
// D. 2 2 4 3
// E. 2 4 1 3           --> CORRECT, remove() takes from the front, add() adds to the end, poll() takes from front
// F. 2 2 3 3 4
// G. Compilation fails
// H. An exception is thrown at runtime