package Chapter10_Threads.Questions;

public class Question12 {
    static Thread laurel, hardy;

    public static void main(String[] args) {
        laurel = new Thread() {
            public void run() {
                System.out.println("A");
                try {
                    hardy.sleep(1000);     // --> sleep() is a static method so can be called from an instance!!!
                } catch (Exception e) {
                    System.out.println("B");
                }
                System.out.println("C");
            }
        };
        hardy = new Thread() {
            @Override
            public void run() {
                System.out.println("D");
                try {
                    laurel.wait();
                } catch (Exception e) {
                    System.out.println("E");
                }
                System.out.println("F");
            }
        };
        laurel.start();
        hardy.start();
    }
}

// Which letters will eventually appear somewhere in the output? (Choose all that apply)

// A. A             --> CORRECT
// B. B
// C. C             --> CORRECT
// D. D             --> CORRECT
// E. E             --> CORRECT
// F. F             --> CORRECT
// G. The answer cannot reliably be determined
// H. The code does not compile


// A, C, D, E, and F are correct. This may look like laurel and hardy are battling to cause the other to sleep() or
// wait()—but that’s not the case. Since sleep() is a static method, it affects the current thread, which is laurel
// (even though the method is invoked using a reference to hardy). That’s misleading, but perfectly legal, and the
// Thread laurel is able to sleep with no exception, printing A and C (after at least a one-second delay).
// Meanwhile, hardy tries to call laurel.wait()—but hardy has not synchronized on laurel, so calling laurel.wait()
// immediately causes an IllegalMonitorStateException, and so hardy prints D, E, and F. Although the order of
// the output is somewhat indeterminate (we have no way of knowing whether A is printed before D, for example),
// it is guaranteed that A, C, D, E, and F will all be printed in some order, eventually—so G is incorrect.

// B, G, and H are incorrect based on the above. (OCP Objective 10.2)