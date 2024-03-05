package Chapter10_Threads.Defining_Starting_Threads;

public class ExtendThreadExample extends Thread {

    // The below method is called when you start a thread
    public void run() {
        System.out.println("Important job running in ExtendThreadExample");
    }

    // The below method can exist as an overload but it will not be called and will not start another thread
    public void run(String s) {
        System.out.println("String in run is " + s);
    }

    public static void main(String[] args) {

        // Instantiate a thread
        ExtendThreadExample t = new ExtendThreadExample();

        // start it
        t.start();
    }
}
