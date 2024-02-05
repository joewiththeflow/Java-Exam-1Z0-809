package Chapter5_IO_and_NIO;
import java.io.Console;

// This doesn't actually work for some reason, the console is null. Could probably use System.in instead
public class NewConsole {
    public static void main(String[] args) {
        String name = "";
        Console c = System.console();                       // 1. Get a Console
        char[] pw;
        pw = c.readPassword("%s", "pw: ");      // 2. return a char
        for(char ch : pw) {
            c.format("%c ", ch);                        // 3. format output
        }
        c.format("\n");

        MyUtility mu = new MyUtility();
        while(true) {
            name = c.readLine("%s", "input>: ");    //4. return a String

            c.format("output: %s \n", mu.doStuff(name));
        }
    }
}

class MyUtility {                                               // 5. class to test
    String doStuff(String arg1) {
        //stub code
        return "result is " + arg1;
    }
}
