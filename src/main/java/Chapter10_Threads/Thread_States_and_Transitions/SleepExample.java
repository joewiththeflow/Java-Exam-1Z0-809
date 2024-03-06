package Chapter10_Threads.Thread_States_and_Transitions;

public class SleepExample {
    public static void main(String[] args) {

        // Make one runnable
        NameRunnable nr = new NameRunnable();

        Thread one = new Thread(nr);
        one.setName("Fred");
        Thread two = new Thread(nr);
        two.setName("Lucy");
        Thread three = new Thread(nr);
        three.setName("Ricky");

        one.start();
        two.start();
        three.start();
    }
}

class NameRunnable implements Runnable {

    @Override
    public void run() {
        for (int x = 1; x < 4; x++) {
            System.out.println("Run by "
            + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);         // this is a static method of Thread - puts the current thread to sleep
            } catch (InterruptedException e) {}
        }
    }
}
