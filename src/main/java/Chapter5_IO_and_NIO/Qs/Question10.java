package Chapter5_IO_and_NIO.Qs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.DosFileAttributes;
import java.nio.file.attribute.PosixFileAttributes;

public class Question10 {
    public static void main(String[] args) throws IOException {
        read(Paths.get("src/main/java/Chapter5_IO_and_NIO/Qs/question2/dir1"));
    }
    // Given:
    public static void read(Path dir) throws IOException {
// Which code inserted at // CODE HERE will compile and run without error on Windows? (Choose all that apply)

//      A.
      BasicFileAttributes attr = Files.readAttributes(dir, BasicFileAttributes.class);      // ---> CORRECT
//      B.
//      BasicFileAttributes attr = Files.readAttributes(dir, DosFileAttributes.class);          // ---> CORRECT
//      C.
//      DosFileAttributes attr = Files.readAttributes(dir, BasicFileAttributes.class);
//      D.
//      DosFileAttributes attr = Files.readAttributes(dir, DosFileAttributes.class);          // ---> CORRECT
                                                                                              // On a Unix machine I would get an
                                                                                              // UnsupportedOperationException
//      E.
//      PosixFileAttributes attr = Files.readAttributes(dir, PosixFileAttributes.class);   // ---> Although this works on Posix
                                                                                         // machines, on WINDOWS it would
                                                                                         // throw an UnsupportedOperationException

//      F.
//      BasicFileAttributes attr = new BasicFileAttributes(dir);
//      G.
//      BasicFileAttributes attr = dir.getBasicFileAttributes();

        // CODE HERE
        System.out.println(attr.creationTime());

    }
}
