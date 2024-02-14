package Chapter5_IO_and_NIO.Qs;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

// Given:
public class Question13 extends SimpleFileVisitor<Path> {
    // more code here
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        System.out.println("File " + file);
        if (file.getFileName().endsWith("Test.java")) {
            // CODE HERE
        }
        return FileVisitResult.CONTINUE;
    }
    // more code here
}

// Which code inserted at // CODE HERE would cause the FileVisitor to stop visiting files after it sees the file Test.java?

// A. return FileVisitResult.CONTINUE;
// A. return FileVisitResult.END;
// A. return FileVisitResult.SKIP_SIBLINGS;
// A. return FileVisitResult.SKIP_SUBTREE;
// A. return FileVisitResult.TERMINATE;     --> CORRECT
// A. return null;                          --> Possibly