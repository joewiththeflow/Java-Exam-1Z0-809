package Chapter5_IO_and_NIO.Files_Navigation_and_io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class CopyingMovingDeletingFiles {
    public static void main(String[] args) {

        // Create dir with file
        Path temp = Paths.get("temp");
        Path source = Paths.get("temp/test1.txt");
        try {
//            Files.createDirectory(temp);          // already exists
            Files.createFile(source);
        } catch (IOException e) { }

        // Copy, delete, move
        Path target = Paths.get("temp/test2.txt");          // doesn't exist

        try {
            Files.copy(source, target);                         // now two copies of file
            Files.delete(target);                               // bac to one copy
            Files.move(source, target);                         // still one copy
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        // At this point, the above copy will fail and throw IOException as target file, test2.txt, already exists
        // from previous run, but you could do SandardCopyOption.REPLACE_EXISTING


        // To replace an existing file when copying
        source = Paths.get("temp/test3.txt");
        try {
            System.out.println(Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING));    // NEED TO SPECIFY IF FILE ALREADY EXISTS
                                                                                // Otherwise FileAlreadyExistsException
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        //Delete a file if it doesn't exists?
        Path path = Paths.get("temp/madeup.txt");
        try {
//            Files.delete(path);       // NoSuchFileException
            Files.deleteIfExists(path); // returns true or false - BETTER OPTION
        } catch (IOException e) { }
    }
}
