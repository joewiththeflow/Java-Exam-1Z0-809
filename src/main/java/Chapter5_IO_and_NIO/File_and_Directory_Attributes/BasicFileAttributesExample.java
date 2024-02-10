package Chapter5_IO_and_NIO.File_and_Directory_Attributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;

public class BasicFileAttributesExample {
    public static void main(String[] args) {

        Path path = Paths.get("fileWrite1.txt");

        try {

            // READ

            BasicFileAttributes basic = Files.readAttributes(path, BasicFileAttributes.class);
            System.out.println("create: " + basic.creationTime());
            System.out.println("access: " + basic.lastAccessTime());
            System.out.println("modify: " + basic.lastModifiedTime());
            System.out.println("directory: " + basic.isDirectory());

            //create: 2023-11-10T13:33:32Z
            //access: 2024-02-10T14:22:58Z
            //modify: 2024-02-10T14:22:57Z
            //directory: false

            // SET
            FileTime lastUpdated = basic.lastModifiedTime();
            FileTime created = basic.creationTime();
            FileTime now = FileTime.fromMillis(System.currentTimeMillis());

            // Need the BasicFileAttributeView object to set BasicFileAttribute values !!!!!!!!!!!!!!
            BasicFileAttributeView basicView = Files.getFileAttributeView(path, BasicFileAttributeView.class);
            basicView.setTimes(lastUpdated, now, created);
            // Pass null for any of the 3 values you do not wish to update in the above method
            // args are: (lastModifiedTime, lastAccessedTime, createTime)

        } catch(IOException e) { }

    }
}
