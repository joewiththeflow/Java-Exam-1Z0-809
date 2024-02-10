package Chapter5_IO_and_NIO.Files_Path_and_Paths;

import java.io.File;
import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CreatePath {
    public static void main(String[] args) {
        Path p1 = Paths.get("/tmp/file.txt");   // UNIX
        Path p2 = Paths.get("c:\\temp\\test");  // Windows

        Path p3 = Paths.get("/tmp", "file1.txt");       // same as p1
        Path p4 = Paths.get("c:", "temp", "test");      // same as p2
        Path p5 = Paths.get("c:\\temp", "test");        // same as p2

        // You need to be careful if your path is not starting at root
        Path p6 = Paths.get("tmp", "file1.txt");    // RELATIVE PATH - not the same as p1
            // If the program is run from root, this would be: /tmp/file1.txt
            // If the program is run from /tmp, this would be: /tmp/tmp/file1.txt


        // Sometimes you might have a path like this "file:///c:/tmp"
        // But the following will complain about the colon after file and is not allowed:
        Path p7  = Paths.get("file:///c:/tmp/test");

        // To solve the problem you can use:
        Path p8 = Paths.get(URI.create("file:///c:/tmp"));


        // Paths.get() is actually a shortcut as there is a check to find out which filesystem type is in use
        Path shorter = Paths.get("c:", "tmp");
        Path longer = FileSystems.getDefault().getPath("c:", "temp");


        // If you want to convert between code that is pre Java 7 with later versions
        File file = new File("pretendylocation");
        Path convertedToPath = file.toPath();
        File convertedToFile = convertedToPath.toFile();
    }
}
