package Chapter10_Threads.Defining_Starting_Threads;

public class ThreadExample {
    public static void main(String[] args) {
        Runnable r = () -> {
            for (int x = 1; x < 6; x++) {
                System.out.println("Runnable running " + x);
            }
        };
        Thread t = new Thread(r);
        t.start();

        // Produces:
//        Runnable running 1
//        Runnable running 2
//        Runnable running 3
//        Runnable running 4
//        Runnable running 5

        // You can legally call run() directly rather than start()
        // BUT IT WILL NOT RUN IN ANOTHER THREAD!!!
    }
}
