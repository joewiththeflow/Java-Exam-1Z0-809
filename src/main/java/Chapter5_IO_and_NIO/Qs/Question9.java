package Chapter5_IO_and_NIO.Qs;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Question9 {
//  Given:
public static void main(String[] args) {
//    new File("c:/temp/test.txt").delete();

//    How would you write this line of code using Java 7 APIs?

    try {
//    A.
        Files.delete(Paths.get("c:/temp/test.txt"));            //---> Need a try catch for this, pre Java 7 method returns false
//    B.
        Files.deleteIfExists(Paths.get("c:/temp/test.txt"));    //---> CORRECT - returns false if it doesn't exist, just like pre Java 7 method
//    C.
//      Files.deleteOnExit(Paths.get("c:/temp/test.txt"));       // method doesn't exist
//    D.
//      Paths.get("c:/temp/test.txt").delete();                  // method doesn't exist, should use Files for deletion
//    E.
//      Paths.get("c:/temp/test.txt").deleteIfExists();          // method doesn't exist, should use Files for deletion
//    F.
//      Paths.get("c:/temp/test.txt").deleteOnExit();             // method doesn't exist, should use Files for deletion
    } catch(IOException e) { }
}

}

