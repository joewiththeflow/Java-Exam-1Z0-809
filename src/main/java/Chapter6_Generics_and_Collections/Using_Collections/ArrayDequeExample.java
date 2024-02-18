package Chapter6_Generics_and_Collections.Using_Collections;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;

public class ArrayDequeExample {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(10, 9, 8, 7, 6, 5);

        // Create several ArrayDequeus, each with space for 2 items
        ArrayDeque<Integer> a = new ArrayDeque<>(2);
        ArrayDeque<Integer> b = new ArrayDeque<>(2);
        ArrayDeque<Integer> c = new ArrayDeque<>(2);
        ArrayDeque<Integer> d = new ArrayDeque<>(2);
        ArrayDeque<Integer> e = new ArrayDeque<>(2);

        // add 6 items to each Deque, each using different methods
        for(Integer n : nums) {
            a.offer(n);         // add on the end
            b.offerFirst(n);    // add on the front
            c.push(n);          // add on the front
            d.add(n);           // add on the end
            e.addFirst(n);      // add on the front
        }

        // display the deques
        System.out.println("a: " + a);
        System.out.println("b: " + b);
        System.out.println("c: " + c);
        System.out.println("d: " + d);
        System.out.println("e: " + e);


        // Accessing elements in the Deque
        System.out.println("First element of e (e.peek()): " + e.peek());
        System.out.println("e hasn't changed: " + e);

        System.out.println("First element of e (e.poll()): " + e.poll());
        System.out.println("e has been modified: " + e);

        System.out.println("First element of e (e.pop()): " + e.pop());
        System.out.println("e has been modified: " + e);

        System.out.println("Last element of e (e.pollLast()): " + e.pollLast());
        System.out.println("e has been modified: " + e);

        System.out.println("Remove all remaining elements of e (e.removeLast() x3): " +
                e.removeLast() + " " + e.removeLast() + " " + e.removeLast());
        System.out.println("e has been modified: " + e);


        // Accessing an empty Deque
//        System.out.println("Try to pop one more item: " + e.pop());       // NoSuhElementException

//        System.out.println("Try to remove one more item: " + e.remove()); // NoSuhElementException

        System.out.println("Try to poll one more item: " + e.poll());   // null
    }
}
