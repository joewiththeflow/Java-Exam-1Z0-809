package Chapter5_IO_and_NIO.Directory_Stream;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DirectoryStreamExample {
    public static void main(String[] args) {
        Path dir = Paths.get("/users");
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) { // try with resources style so we don't need to close

            for(Path path : stream) {
                System.out.println(path.getFileName());
            }
            //Produces:

            // .localized
            // Shared
            // joe
        } catch (IOException e) { }

        try  (DirectoryStream<Path> stream = Files.newDirectoryStream(dir, "[jS]*")) { // j or S followed by anything
                                                                                            // this is a glob not a regex
                                                                                            // regex would be "[vw].*"
            for (Path path: stream) {
                System.out.println(path.getFileName());
            }
            // Produces
            // Shared
            // joe
        } catch (IOException e) {}


    }
}
