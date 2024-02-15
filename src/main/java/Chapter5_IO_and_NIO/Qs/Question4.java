package Chapter5_IO_and_NIO.Qs;

import java.io.Console;

// Given:
public class Question4 {
    public static void main(String[] args) {
        Console c = System.console();
        String u = c.readLine("%s", "username: ");
        System.out.println("hello " + u);
        String pw;
//        if(c != null && (pw = c.readPassword("%s", "password: ")) != null)
            // check for valid password
    }
}

// If line 8 creates a valid Console object and if the user enters fred as a username and 1234 as a password,
// what is the result?

// A. username:
//        password:
// B: username: fred        ---> If it was char[], not a String, this would be correct
//      password:
// C: username: fred
//      password: 1234
// D: Compilation fails     ---> readPassword() returns a char[], not a String, so compilation fails as pw is of type String
