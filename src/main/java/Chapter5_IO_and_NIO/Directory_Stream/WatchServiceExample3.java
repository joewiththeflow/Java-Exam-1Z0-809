package Chapter5_IO_and_NIO.Directory_Stream;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

// Add text to watchDir2/parent/p.txt
// Add text to watchDir2/parent/child/c.txt
// Produces:

    //ENTRY_MODIFY
    //interface java.nio.file.Path
    //        parent
    //ENTRY_MODIFY
    //interface java.nio.file.Path
    //p.txt
    //p.txtENTRY_MODIFY
    //
    //        ENTRY_MODIFY
    //interface java.nio.file.Path
    //        child
    //ENTRY_MODIFY
    //interface java.nio.file.Path
    //c.txt
    //c.txtENTRY_MODIFY
public class WatchServiceExample3 {
    public static void main(String[] args) {
        Path myDir = Paths.get("watchDir2");

        try {
            Files.deleteIfExists(Paths.get("watchDir2/parent/child/c.txt"));
            Files.deleteIfExists(Paths.get("watchDir2/parent/p.txt"));
            Files.deleteIfExists(Paths.get("watchDir2/parent/child/"));
            Files.deleteIfExists(Paths.get("watchDir2/parent"));
            Files.deleteIfExists(Paths.get("watchDir2"));

            Files.createDirectories(Paths.get("watchDir2/parent/child"));
            Files.createFile(Paths.get("watchDir2/parent/p.txt"));
            Files.createFile(Paths.get("watchDir2/parent/child/c.txt"));

            final WatchService watcher = FileSystems.getDefault().newWatchService();

            Files.walkFileTree(myDir, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                    dir.register(watcher, StandardWatchEventKinds.ENTRY_MODIFY);    // watch each directory for modify
                    return FileVisitResult.CONTINUE;
                }
            });

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

                    if (name.equals("p.txt")) {
                        System.out.println(name + kind.name());
                        System.out.println();
                    } else if (name.equals("c.txt")) {
                        System.out.println(name + kind.name());
                        System.out.println();
                    }
                    key.reset();    // You need to call this or it will only work the first time!
                }
            }
        } catch (IOException e) {}
    }
}
