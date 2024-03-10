package Chapter10_Threads.Synchronizing_Code;

public class SynchronizeExamples {
    public static void main(String[] args) {
        try {
            SynchronizeExamples.classMethod();
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }

    // There is one lock per instance of a class

    // synchronize an instance method:
    public synchronized void doStuff() {
        System.out.println("synchronized");
    }

    // The above is equivalent (in practical terms) to using a synchronized block:
    public void doStuff2() {
        synchronized(this) {
            System.out.println("synchronized");
        }
    }

    // Can synchronize a static method, uses java.lang.Class instance representing the class in question
    // There is one lock per class to synchronize static methods (i.e. rather than a lock per instance)
    // It's that java.lang.Class instance whose lock is used to protect any snchronized static methods of the class

    public static synchronized int getCount() {
        return 5;
    }

    // The above could be replaced with a synchronized block
    public static int getCount2() {
        synchronized(SynchronizeExamples.class) {       // class literal, the instance of Class that represents
                                                        // the class SynchronizeExamples
            return 5;
        }
    }

    // You can also get the instance of Class that represents the class SyncnhronizeExamples:
    public static void classMethod() throws ClassNotFoundException {
        Class c1 = Class.forName("Chapter10_Threads.Synchronizing_Code.SynchronizeExamples");
        synchronized(c1) {
            System.out.println("Synchronized c1");
        }
    }
}
