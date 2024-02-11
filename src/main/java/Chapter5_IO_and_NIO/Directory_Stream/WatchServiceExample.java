package Chapter5_IO_and_NIO.Directory_Stream;

import java.nio.file.*;

import static java.nio.file.StandardWatchEventKinds.ENTRY_DELETE;       // need these static imports

// You need to first have a directory in watchDir called delDir before running this program
// Run the program
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
                        System.out.println("just going to recreate the dir again for next run of program...");

                        Path delDir = Paths.get("watchDir/delDir");
                        Files.createDirectory(delDir);          // recreate delDir for running program next time
                        System.out.println("delDir recreated");

                        return;     // end program
                    }
                }
            }

        } catch (Exception e) {}


    }
}
