package Chapter11_Concurrency.Concurrent_Collections;

import java.util.ArrayList;
import java.util.List;

// The following example is likely to run into an ArrayIndexOutOfBoundsException
// You could use synchronization blocks but this reduces performance
// Another option is to use Copy-on-Write collections from java.util.concurrent
public class UnsafeArrayListExample implements Runnable {
    // shared by all threads
    private List<Integer> list = new ArrayList<>();

    public UnsafeArrayListExample() {
        // add some elements
        for(int i = 0; i < 100000; i++) {
            list.add(i);
        }
    }

    // might run concurrently, you cannot be sure
    // to be safe you must assume it does   - not really sure is this is the best description but lifted from book
    @Override
    public void run() {
        String tName = Thread.currentThread().getName();
        while(!list.isEmpty()) {
            System.out.println(tName + " removed " + list.remove(0));
        }
    }

    public static void main(String[] args) {
        UnsafeArrayListExample alr = new UnsafeArrayListExample();
        Thread t1 = new Thread(alr);
        Thread t2 = new Thread(alr);
        t1.start();
        t2.start();
    }
}
