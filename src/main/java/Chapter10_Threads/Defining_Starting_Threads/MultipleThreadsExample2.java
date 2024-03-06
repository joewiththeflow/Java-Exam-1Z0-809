package Chapter10_Threads.Defining_Starting_Threads;

public class MultipleThreadsExample2 {
    public static void main(String[] args) {
        // Make one Runnable
        Runnable nr = () -> {
            for (int x = 1; x <= 3; x++) {
                System.out.println("Run by " +
                        Thread.currentThread().getName() + ", x is " + x);
            }
        };
        Thread one = new Thread(nr);
        Thread two = new Thread(nr);
        Thread three = new Thread(nr);

        one.setName("Fred");
        two.setName("Lucy");
        three.setName("Ricky");

        one.start();
        two.start();
        three.start();

        // Might produce:

//        Run by Fred, x is 1
//        Run by Fred, x is 2
//        Run by Fred, x is 3
//        Run by Ricky, x is 1
//        Run by Lucy, x is 1
//        Run by Ricky, x is 2
//        Run by Ricky, x is 3
//        Run by Lucy, x is 2
//        Run by Lucy, x is 3
    }
}
