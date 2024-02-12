package Chapter5_IO_and_NIO.Directory_Stream;

import java.io.IOException;
import java.nio.file.*;

import static java.nio.file.StandardWatchEventKinds.*;

// Run the program
// You may have to Right click the project and 'Reload from Disk' to get the watchDir to appear
// 1. Create new file file1.txt in watchDir/delCre directory
// 2. Create new dir createdDir in watchDir/delCre directory
// 3. Rename file2.txt to file2.txt
// 4. Rename createdDir to createdDir2
// 6. Add some text to newFile.txt and Save
// 7. Create fileToDelete.txt in delDir
// 7. Manually delete fileToDelete.txt
// It may take a few seconds as WatchService is not 100% reliable and it is slow - unlikely to use on the job
// Produces:

    //ENTRY_CREATE
    //interface java.nio.file.Path
    //file1.txt
    //File created: file1.txt, event was: ENTRY_CREATE
    //
    //        ENTRY_CREATE
    //interface java.nio.file.Path
    //        createdDir
    //File created: createdDir, event was: ENTRY_CREATE
    //
    //        ENTRY_CREATE
    //interface java.nio.file.Path
    //file2.txt
    //File created: file2.txt, event was: ENTRY_CREATE
    //
    //        ENTRY_DELETE
    //interface java.nio.file.Path
    //file1.txt
    //File created: file1.txt, event was: ENTRY_DELETE
    //
    //        ENTRY_CREATE
    //interface java.nio.file.Path
    //        createdDir2
    //Not something we were watching
    //Name for event: createdDir2, event was: ENTRY_CREATE
    //
    //        ENTRY_DELETE
    //interface java.nio.file.Path
    //        createdDir
    //File created: createdDir, event was: ENTRY_DELETE
    //
    //        ENTRY_MODIFY
    //interface java.nio.file.Path
    //newFile.txt
    //File modified: newFile.txt, event was: ENTRY_MODIFY
    //
    //        ENTRY_DELETE
    //interface java.nio.file.Path
    //fileToDelete.txt
    //Not something we were watching
    //Name for event: fileToDelete.txt, event was: ENTRY_DELETE

public class WatchServiceExample2 {
    public static void main(String[] args) {

        Path dir1 = Paths.get("watchDir/delDir");
        Path dir2 = Paths.get("watchDir/delCreDir");
        Path dir3 = Paths.get("watchDir/delCreModDir");

        // create directory structure in case it doesn't already exist:
        try {
            // using full paths from this file just to prove I understand how it works
            Files.createDirectories(Paths.get("./" + dir1));
            Files.createDirectories(Paths.get("./" + dir2));
            Files.createDirectories(Paths.get("./" + dir3));
            Files.deleteIfExists(Paths.get(dir1 + "/fileToDelete.txt"));
            Files.deleteIfExists(Paths.get(dir2 + "/file1.txt"));
            Files.deleteIfExists(Paths.get(dir2 + "/file2.txt"));
            Files.deleteIfExists(Paths.get(dir3 + "/newFile.txt"));
            Files.deleteIfExists(Paths.get(dir2 + "/createdDir"));
            Files.deleteIfExists(Paths.get(dir2 + "/createdDir2"));
            Files.createFile(Paths.get("./" + dir3 + "/newFile.txt"));
            Files.createFile(Paths.get("./" + dir1 + "/fileToDelete.txt"));

        }   catch (IOException e) {}

        try {
            WatchService watcher = FileSystems.getDefault().newWatchService();      // create empty WaatchService
                                                                                    // needs try catch for IOException
            dir1.register(watcher, ENTRY_DELETE);        // start watching for deletions
            dir2.register(watcher, ENTRY_DELETE, ENTRY_CREATE); // deletions and creations (new file or dir created)
                                                                // a rename of file or dir is also a del/create
            dir3.register(watcher, ENTRY_DELETE, ENTRY_CREATE, ENTRY_MODIFY);   // file modified

            while (true) {
                WatchKey key;
                try {
                    key = watcher.take();                      // wait for a deletion
                    // take() is most common although you could use poll():
                    // watcher.poll();                          // Get event if present right NOW
                    // watcher.poll(10, TimeUnit.SECONDS)       // wait up to 10 seconds for an event
                    // watcher.poll(1, TimeUnit.SECONDS)        // wait up to 1 minute for an event
                } catch (InterruptedException e) {
                    return;                                     // give up if something goes wrong
                }

                for (WatchEvent<?> event : key.pollEvents()) {
                    WatchEvent.Kind<?> kind = event.kind();
                    System.out.println(kind.name());            // can be create, delete, modify
                    System.out.println(kind.type());            // should always be a Path for this program
                    System.out.println(event.context());        // name of the file
                    String name = event.context().toString();

                    if (name.equals("delDir")) {
                        System.out.println("Directory delDir deleted, now we can proceed");
                        return;     // end program
                    } else if (name.equals("file1.txt") || name.equals("createdDir") || name.equals("file2.txt")) {
                        System.out.println("File created: " + name + ", event was: " + kind.name());
                        System.out.println();
                    } else if (name.equals("newFile.txt")) {
                        System.out.println("File modified: " + name + ", event was: " + kind.name());
                        System.out.println();
                    } else {
                        System.out.println("Not something we were watching");
                        System.out.println("Name for event: " + name + ", event was: " + kind.name());
                        System.out.println();
                    }
                }
                key.reset();    // You need to call this or it will only work the first time!
            }

        } catch (Exception e) {}


    }
}
