package Chapter5_IO_and_NIO.Qs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

//Given:
public class Question3 {
    public static void main(String[] args) {
        String s;
        try {
            FileReader fr = new FileReader("src/main/java/Chapter5_IO_and_NIO/Qs/question3/myfile.txt");
            BufferedReader br = new BufferedReader(fr);
            while((s = br.readLine()) != null)
                System.out.println(s);
//            br.flush();                       ------> the key is that a bufferedReader has no flush() method
        } catch (IOException e) { System.out.println("io error"); }
    }
}

// and given that "myfile.txt contains the following 2 lines of data:

// ab
// ac

// What is the result?

// A. ab
// B. abcd
// C. ab
//    cd
// D. a
//    b
//    c
//    d
// E. Compilation fails         -----> BufferedReader has no flush() method !!!!!!