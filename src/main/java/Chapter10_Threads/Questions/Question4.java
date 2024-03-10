package Chapter10_Threads.Questions;

public class Question4 {
    private int a;
    private int b;

    // Which of the following pairs can prevent concurrent access problems in this class?

    // A. public int read() { return a + b; }
    //    public void set(int a, int b) { this.a = a; this.b = b; }
    // B. public synchronized int read() {return a + b; }                           --> CORRECT
    //    public synchronized void set(int a, int b) { this.a = a; this.b = b; }
    // C. public int read() { synchronized(a) { return a + b; }
    //    public void set(int a, int b) { synchronized(a) { this.a = a; this.b = b; }}
    // D. public int read() { synchronized(a) { return a + b; }
    //    public void set(int a, int b) { synchronized(b) { this.a = a; this.b = b; }}
    // E. public synchronized(this) int read() { return a + b; }
    //    public synchronized(this) void set(int a, int b)  { this.a = a; this.b = b; }
    // F. public int read() { synchronized(this) { return a + b; }                      --> CORRECT
    //    public void set(int a, int b) { synchronized(this) { this.a = a; this.b = b; }}

    // Remember, you can't synchronize on variables, only Objects
}
