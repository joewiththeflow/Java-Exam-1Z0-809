package Chapter5_IO_and_NIO.Directory_Stream;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class SimpleFileVisitorPrintDirs extends SimpleFileVisitor<Path> {

    // called before drilling down into directory
    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
        System.out.println("pre: " + dir);
        String name = dir.getFileName().toString();
        if (name.equals("dir4"))
            return FileVisitResult.SKIP_SUBTREE;     // skip dir4
        return FileVisitResult.CONTINUE;

        // There are a few other FileVisitResults on Line 16
        // . TERMINATE - as soon as dir hit, will stop walking file tree
        // SKIP_SIBLINGS - skip dir4 AND any other dirs at same level
    }

    // Just called for files
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        System.out.println("file: " + file);
        return FileVisitResult.CONTINUE;
    }

    // Only called if error accessing file - usually a permissions issue
    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    // called when finished with directory on way back up
    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        System.out.println("post: " +  dir);
        return FileVisitResult.CONTINUE;
    }

    public static void main(String[] args) {
        SimpleFileVisitorPrintDirs dirs = new SimpleFileVisitorPrintDirs();
        try {
            Files.walkFileTree(Paths.get("searchThis"), dirs);
        } catch (IOException e) { }

        // Produces:
//        pre: searchThis
//        file: searchThis/file2.txt
//        file: searchThis/file1.txt
//        pre: searchThis/dir2
//        file: searchThis/dir2/dir4.txt
//        post: searchThis/dir2
//        pre: searchThis/dir3
//        post: searchThis/dir3
//        pre: searchThis/dir1
//        file: searchThis/dir1/file3.txt
//        post: searchThis/dir1
//        post: searchThis

        // It is a "depth-first" search, goes as far as it can before returning back up the tree
        // directories at same level can get visited in any order

        // The last 2 mthods have IOException as a parameter, allowing exceptions to be handled earlier



    }
}
