package Chapter10_Threads.Synchronizing_Code;

public class SynchronizeExercise extends Thread {
    // I think the mthods of StringBuffer seem to be synchronized as is, so even without synchronizing on the single
    // instance of sb, the code will appear to behave as if synchronized

    private StringBuffer sb;
    public static void main(String[] args) {

        // Create a single StringBuffer object which will be used to create 3x separate SynchronizeExercise
        StringBuffer sb = new StringBuffer("A");
        SynchronizeExercise se1 = new SynchronizeExercise(sb);
        SynchronizeExercise se2 = new SynchronizeExercise(sb);
        SynchronizeExercise se3 = new SynchronizeExercise(sb);

        // Run the 3 new SynchronizeExercise threads
        se1.start();
        se2.start();
        se3.start();
    }

    public SynchronizeExercise(StringBuffer sb) {
        this.sb = sb;
    }

    @Override
    public void run() {
        synchronized(sb) {
            for (int i = 1; i <= 100; i++) {
                System.out.println(sb);
            }
            char temp = sb.charAt(0);
            ++temp;
            sb.setCharAt(0, temp);
        }
    }
}
