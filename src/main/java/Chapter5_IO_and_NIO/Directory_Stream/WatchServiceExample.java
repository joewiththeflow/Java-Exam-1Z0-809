package Chapter5_IO_and_NIO.Directory_Stream;

import java.io.IOException;
import java.nio.file.*;

import static java.nio.file.StandardWatchEventKinds.ENTRY_DELETE;       // need these static imports

// Run the program
// You may have to Right click the project and 'Reload from Disk' to get the watchDir to appear
// Manually delete delDir
// It may take a few seconds as WatchService is not 100% reliable and it is slow - unlikely to use on the job
// Produces:
    //ENTRY_DELETE
    //interface java.nio.file.Path
    //        delDir
    //Directory delDir deleted, now we can proceed

public class WatchServiceExample {
    public static void main(String[] args) {

        Path dir = Paths.get("watchDir");   // parent directory to watch

        // create directory structure in case it doesn't already exist:
        try {
            Files.createDirectories(Paths.get("watchDir/delDir"));
        }   catch (IOException e) {}

        try {
            WatchService watcher = FileSystems.getDefault().newWatchService();      // create empty WaatchService
                                                                                    // needs try catch for IOException
            dir.register(watcher, ENTRY_DELETE);        // start watching for deletions

            while (true) {
                WatchKey key;
                try {
                    key = watcher.take();                      // wait for a deletion
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
                    }
                }
            }

        } catch (Exception e) {}


    }
}
