package Chapter10_Threads.Thread_Interaction;

public class NotifyAllExample extends Thread {
    Calculator c;

    public NotifyAllExample(Calculator calc) {
        c = calc;
    }

    @Override
    public void run() {
        synchronized(c) {
            try {
                System.out.println("Waiting for calculation...");
                c.wait();
            } catch (InterruptedException e) {}
            System.out.println("Total is: " + c.total);
        }
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        new NotifyAllExample(calculator).start();
        new NotifyAllExample(calculator).start();
        new NotifyAllExample(calculator).start();
        new Thread(calculator).start();             // we need this one to use the run method in Calculator
    }
}

class Calculator implements Runnable {
    int total;
    @Override
    public void run() {
        synchronized(this) {
            for (int i =0; i < 100; i++) {
               total += i;
            }
            notifyAll();
        }
    }
}
