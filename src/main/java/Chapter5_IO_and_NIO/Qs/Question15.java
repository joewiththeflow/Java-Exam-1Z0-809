package Chapter5_IO_and_NIO.Qs;

import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Question15 {
//    Given a partial directory tree at the root of the drive:

//    dir x - |
//    ----------| - file a.txt
//    ----------| - dir y
//    -------------------| - file b.txt
//    -------------------| - dir y
//    -----------------------------| - file c.txt

//    And the following snippet:
//public static void main(String[] args) {
//    Path dir = Paths.get("src/main/java/Chapter5_IO_and_NIO/Qs/question15/x");
//    try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir, "**/*")) {
//        for (Path path : stream) {
//            System.out.println(path);
//        }
//    } catch (Exception e) { }
//}

// What is the result?

//    A. c:/x/a.txt
//    B. c:/x/a.txt
//       c:/x/a/b.txt
//       c:/x/y/z/c.txt
//    C. Code compiles but does not output anything     ---> CORRECT because DirectoryStream only looks for files in the
//                                                        // immediate directory. **/*.txt means zero or more directories
//                                                        followed by a /, followed by zero or more charcteres followed by .txt.
//                                                        Since the slash is there, it is required to match, which makes
//                                                        it mean one or more directories. However, this is impossible as
//                                                        DirectoryStream only looks at one directory. If the expression
//                                                        were simply *.txt, A would be correct
//    D. Does not compile because DirectoryStream comes from FileSystems, not Files
//    E. Does not compile for another reason
}
