package Chapter5_IO_and_NIO.File_and_Directory_Attributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFileAttributes;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;

public class PosixFileAttributesExample {
    public static void main(String[] args) {
        // On unix, every file and directory has both an owner and a group name
        // Each file or directory has 9 permissions
        // rwxrw-r--
        // rwx                          rw-                     r--
        // Owner                        Group                   Other
        // Read, Write and Execute      Read and Write          Read

        try {
            Path path = Paths.get("temp/file4.txt");
//            Files.createFile(path);

            // READ file perms
            PosixFileAttributes posix = Files.readAttributes(path, PosixFileAttributes.class);
            System.out.println(posix.permissions());        // read file permissions

            // SET file perms
            Set<PosixFilePermission> perms = PosixFilePermissions.fromString("rw-r--r--");
            Files.setPosixFilePermissions(path, perms);

            // Read again
            posix = Files.readAttributes(path, PosixFileAttributes.class);
            System.out.println(posix.permissions());        // read file permissions

            // Group name
            System.out.println(posix.group());

            // Produces
            // [OWNER_WRITE, OTHERS_READ, OWNER_READ, GROUP_READ]
            // [OWNER_WRITE, OTHERS_READ, OWNER_READ, GROUP_READ]
            // staff

        } catch (IOException e) { }


    }
}
