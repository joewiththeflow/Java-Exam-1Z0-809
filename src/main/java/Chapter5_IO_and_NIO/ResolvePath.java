package Chapter5_IO_and_NIO;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ResolvePath {
    public static void main(String[] args) {
        Path dir = Paths.get("/home/java");
        Path file = Paths.get("models/Model.pdf");
        Path result = dir.resolve(file);
        System.out.println(result);
        // Produces:
        //      /home/java/models/Model.pdf

        // path1.resolve(path2) should be read as "resolve path 2 within path 1's directory"

        // Some complex examples
        Path absolute = Paths.get("/home/java");
        Path relative = Paths.get("dir");
        Path file2 = Paths.get("Model.pdf");

        System.out.println("1: " + absolute.resolve(relative));
        System.out.println("2: " + absolute.resolve(file2));
        System.out.println("3: " + relative.resolve(file2));
        System.out.println("4: " + relative.resolve(absolute)); // BAD
        System.out.println("5: " + file2.resolve(absolute));    // BAD
        System.out.println("6: " + file2.resolve(relative));    // BAD

        // 1: /home/java/dir
        // 2: /home/java/models/Model.pdf
        // 3: dir/models/Model.pdf
        // 4: /home/java
        // 5: /home/java
        // 6: models/Model.pdf/dir

        // 4 and 5 use an absolute path, recognised via the root "/", and therefore just returns the path with root
        // 6 is 2 relative paths (without a root) and it doesn't actually check if the path exists

        // EXAM
        // a method like resolve can take either a Path or a String, which can both be null
        // therefore if you pass null, the code won't compile as it won't know which method to use:
        Path e1 = Paths.get("/usr/bin/zip");
        // e1.resolve(null);   // Ambiguous method call

        // However, if you pass in a typed reference that happens to be null, the compiler will know which method to call
        // and so the code will compile, BUT YOU WILL STILL GET A NullPointerException when you run!!!:
        Path other = null;
        e1.resolve(other);
        e1.resolve((String) null);
    }
}
