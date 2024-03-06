package Chapter10_Threads.Thread_States_and_Transitions;

public class SleepExercise extends Thread {

    public void run() {
        for (int i = 1; i <= 100; i++) {
            if (i % 10 == 0) {
                System.out.println(i + " is divisible by 10");
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {}
        }
    }

    public static void main(String[] args) {
        SleepExercise se = new SleepExercise();
        se.start();
    }
}
