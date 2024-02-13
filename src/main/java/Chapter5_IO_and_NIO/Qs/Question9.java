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
        Files.delete(Paths.get("c:/temp/test.txt"));            //---> CORRECT
//    B.
        Files.deleteIfExists(Paths.get("c:/temp/test.txt"));    //---> CORRECT
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

