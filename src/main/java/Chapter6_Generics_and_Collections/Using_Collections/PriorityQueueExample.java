package Chapter6_Generics_and_Collections.Using_Collections;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueExample {

        // It won't allow me to do a static inner class - I think I made a mistake but I'll leave commented
        // suggests it's not possible in Java 8
        // Instead i'll add comparator as lambda

//        class PQsort implements Comparator<Integer> {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2 - o1;                             // inverse sort
//            }
//        }

        public static void main(String[] args) {
            int[] ia = {1,5,3,7,6,9,8};
            PriorityQueue<Integer> pq1 = new PriorityQueue<>();     // natural order at this point

            for (int x : ia )                                       // load queue
                pq1.offer(x);
            for (int x : ia )                                       // review queue
                System.out.print(pq1.poll() + " ");
            System.out.println();

            PriorityQueue<Integer> pq2 = new PriorityQueue<>(10,
                    (one, two) -> two - one);       // use Comparator to reverse order

            for (int x : ia )                                       // load queue
                pq2.offer(x);
            System.out.println("size " + pq2.size());
            System.out.println("peek " + pq2.peek());
            System.out.println("size " + pq2.size());
            System.out.println("poll " + pq2.poll());
            System.out.println("size " + pq2.size());
            for (int x : ia) {                                      // review queue
                System.out.print(pq2.poll() + " ");
            }
        }


}
