package Chapter5_IO_and_NIO.File_and_Directory_Attributes;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.time.*;

public class ReadAndWriteAttributes {
    public static void main(String[] args) {

        // LAST MODIFIED TIME

        ZonedDateTime janFirstDateTime = ZonedDateTime.of(
                LocalDate.of(2017,1,1),
                LocalTime.of(10,0), ZoneId.of("US/Pacific"));   // create a date time
        Instant januaryFirst = janFirstDateTime.toInstant();

        try {
            // old way
            File attribs = new File("attribs");
            attribs.mkdir();
            File file = new File("attribs/file");
            file.createNewFile();
            file.setLastModified(januaryFirst.getEpochSecond() * 1000);        // set time
            System.out.println(file.lastModified());                            // get time
//            file.delete();

            // new way
            Path path = Paths.get("attribs/file2");
            Files.createFile(path);
            FileTime fileTime = FileTime.fromMillis(januaryFirst.getEpochSecond() * 1000);  // FileTime object
            Files.setLastModifiedTime(path, fileTime);
            System.out.println(Files.getLastModifiedTime(path));
//            Files.delete(path);


            // FILE PERMISSIONS (for you running the program)

            // old
            System.out.println(file.canExecute());
            System.out.println(file.canRead());
            System.out.println(file.canRead());

            // new
            System.out.println(Files.isExecutable(path));
            System.out.println(Files.isReadable(path));
            System.out.println(Files.isWritable(path));

//            false
//            true
//            true
//            false
//            true
//            true

        } catch (IOException e) { }

    }
}
