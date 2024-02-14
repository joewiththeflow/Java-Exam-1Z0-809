package Chapter5_IO_and_NIO.Qs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.DosFileAttributes;
import java.nio.file.attribute.PosixFileAttributes;

public class Question10 {

    // Given:
    public void read(Path dir) throws IOException {
// Which code inserted at // CODE HERE will compile and run without error on Windows? (Choose all that apply)

//      A.
//      BasicFileAttributes attr = Files.readAttributes(dir, BasicFileAttributes.class);      // ---> CORRECT
//      B.
//      BasicFileAttributes attr = Files.readAttributes(dir, DosFileAttributes.class);          // ---> CORRECT
//      C.
//      DosFileAttributes attr = Files.readAttributes(dir, BasicFileAttributes.class);
//      D.
//      DosFileAttributes attr = Files.readAttributes(dir, DosFileAttributes.class);          // ---> CORRECT
//      E.
//      PosixFileAttributes attr = Files.readAttributes(dir, PosixFileAttributes.class);         // ---> CORRECT
//      F.
//      BasicFileAttributes attr = new BasicFileAttributes(dir);
//      G.
//      BasicFileAttributes attr = dir.getBasicFileAttributes();

        // CODE HERE
//        System.out.println(attr.creationTime());

    }
}
