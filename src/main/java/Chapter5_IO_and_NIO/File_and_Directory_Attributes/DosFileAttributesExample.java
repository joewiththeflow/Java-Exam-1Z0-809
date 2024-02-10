package Chapter5_IO_and_NIO.File_and_Directory_Attributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.DosFileAttributes;

public class DosFileAttributesExample {
    public static void main(String[] args) {

//        try {
//            Path path = Paths.get("C:/test");
//            Files.createFile(path);
//
//            // SET dos attributes
//            Files.setAttribute(path, "dos:hidden", true);       // set attribute
//            Files.setAttribute((path, "dos:readonly", true);    // notice readonly lowercase
//
//            // READ
//            DosFileAttributes dos = Files.readAttributes(path, DosFileAttributes.class);
//            System.out.println(dos.isHidden());
//            System.out.println(dos.isReadOnly());   // Note camelCase
//
//            // Reverse dos attributes
//            Files.setAttribute(path, "dos:hidden", false);
//            Files.setAttribute(path, "dos:readonly", false);
//
//            // from the code it looks like to need to get the dos attributes again after an update
//            dos = Files.readAttributes(path, DosFileAttributes.class);
//            System.out.println(dos.isHidden());
//            System.out.println(dos.isReadOnly());
//
//            Files.delete(path)
//
//        }
//        catch (IOException e) {}
    }
}
