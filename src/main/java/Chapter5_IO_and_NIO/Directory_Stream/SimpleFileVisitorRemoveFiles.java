package Chapter5_IO_and_NIO.Directory_Stream;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

// This program will go through the classfiles folder and delete any file in any subdir that ends with .class
// Need to actually have files that wend with .classfile in there to see it work
public class SimpleFileVisitorRemoveFiles extends SimpleFileVisitor<Path> { // Need to extend SimpleFileVisitor

    // Need to override the visitFile method in SimpleFileVisitor
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {     // called automatically
        if (file.getFileName().toString().endsWith(".class"))
            Files.delete(file);
        return FileVisitResult.CONTINUE;    // got to next file
    }

    public static void main(String[] args) {
        SimpleFileVisitorRemoveFiles dirs = new SimpleFileVisitorRemoveFiles();
        try {
            Files.walkFileTree(                             // recursive check
                    Paths.get("classfiles"),            // starting point
                    dirs);                                  // visitor object

        } catch (IOException e) {}
    }
}
