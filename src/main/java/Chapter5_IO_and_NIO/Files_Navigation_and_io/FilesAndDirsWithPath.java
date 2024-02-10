package Chapter5_IO_and_NIO.Files_Navigation_and_io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilesAndDirsWithPath {
    public static void main(String[] args) {

        Path path = Paths.get("fileWrite5.txt");
        System.out.println(Files.exists(path));

        try {
            Files.createFile(path);         // IOException if File exists
        } catch (IOException e) { }

        System.out.println(Files.exists(path));


        // Create Directories - The LONG WAY
        Path path0 = Paths.get("java");
        Path path1 = Paths.get("java/source");
        Path path2 = Paths.get("java/source/directory");
        Path file = Paths.get("java/source/directory/Program.java");

        try {
            Files.createDirectory(path0);           // Create dir 0
            Files.createDirectory(path1);           // Create dir 1
            Files.createDirectory(path2);          // Create dir 2
            Files.createFile(file);                 // Create file
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


        // Create Directories in one go
        Path path3 = Paths.get("java2/source/directory");
        Path file2 = Paths.get("java2/source/directory/Program.java");
        try {
            Files.createDirectories(path3);         // Create all dirs
            Files.createFile(file2);                 // Create file
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        // Remember that when a file or directory already exists, an IOException is thrown
    }
}
