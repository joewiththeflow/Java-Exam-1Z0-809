package Chapter5_IO_and_NIO.Directory_Stream;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class PasswordMatcher extends SimpleFileVisitor<Path> {

    private PathMatcher matcher = FileSystems.getDefault().getPathMatcher(
            "glob:**/password/**.txt"
    );

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (matcher.matches(file))
            System.out.println(file);
        return FileVisitResult.CONTINUE;
    }

    public static void main(String[] args) {
        PasswordMatcher dirs = new PasswordMatcher();
        try {
            Files.walkFileTree(Paths.get("pw"), dirs);
        } catch (IOException e) {}

        // Produces:
//        pw/password/secret.txt
//        pw/dir2/password/different.txt
//        pw/dir2/dir4/password/dir6/incognito.txt
//        pw/dir2/dir4/password/random.txt

    }
}
