package Chapter6_Generics_and_Collections.Questions;

import java.util.PriorityQueue;

public class Question9 {
    public static void main(String[] args) {
        PriorityQueue<String> pq = new PriorityQueue<>();
        pq.add("2");
        pq.add("4");
        System.out.print(pq.peek() + " ");
        pq.offer("1");

        pq.add("3");
        pq.remove("1");
        System.out.print(pq.poll() + " ");
        if(pq.remove("2")) System.out.print(pq.poll() + " ");
        System.out.print(pq.poll() + " " + pq.peek());
    }
}

// A. 2 2 3 3
// B. 2 2 3 4               --> CORRECT
// C. 4 3 3 4
// D. 2 2 3 3 3
// E. 4 3 3 3 3
// F. 2 2 3 3 4
// G. Compilation fails
// H. An excpetion is thrown at runtime
