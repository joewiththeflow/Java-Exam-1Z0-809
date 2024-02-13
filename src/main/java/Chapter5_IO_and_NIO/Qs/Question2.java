package Chapter5_IO_and_NIO.Qs;

// Given:

//import java.io.*;

// class Directories {
//  static String [] dirs = {"dir1", "dir2"};
//  public static void main(String[] args) {
//      for (String d: dirs) {

//          //insert code 1 here

//            File file = new File(path, args[0]);

            // insert code 2 here
//       }
//  }
//}

// and the invocation:
    // java Directories file2.txt
// is issued from a directory that has two subdirectories, "dir1" and "dir2", and that "dir1" has a file "file1.txt"
// and "dir2" has a file "file2.txt", and the output is "false true", which set(s) of code fragments must be inserted?
// (Choose all that apply)

import java.io.File;

// A. String path = d;
//      System.out.print(file.exists() + " ");          CORRECT
// B. String path = d;
//      System.out.print(file.isFile() + " ");          CORRECT
// C. String path = File.separator + d;
//      System.out.print(file.exists() + " ");          would be: false, false
// D. String path = File.separator + d;
//      System.out.print(file.isFile() + " ");          would be false, false
public class Question2 {
      static String [] dirs = {"src/main/java/Chapter5_IO_and_NIO/Qs/question2/dir1",
              "src/main/java/Chapter5_IO_and_NIO/Qs/question2/dir2"};
  public static void main(String[] args) {
      for (String d: dirs) {

          //insert code 1 here
          String path = d;
//          String path = File.separator + d;
          File file = new File(path, "file2.txt");     // replace args[0] with "file2.txt

//     insert code 2 here
          System.out.print(file.exists() + " ");
//          System.out.print(file.isFile() + " ");
       }
  }
}
