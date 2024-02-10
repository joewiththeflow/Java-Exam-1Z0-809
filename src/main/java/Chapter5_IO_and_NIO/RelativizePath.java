package Chapter5_IO_and_NIO;

import java.nio.file.Path;
import java.nio.file.Paths;

public class RelativizePath {
    public static void main(String[] args) {
        Path dir = Paths.get("/home/java");
        Path music = Paths.get("/home/java/country/Swift.mp3");
        Path mp3 = dir.relativize(music);
        System.out.println(mp3);
        // Produces: country/Swift.mp3

        // path1.relativize(path2) should be read as "give me a path that shows how to get from path1 to path 2

        // Complex examples
        Path absolute1 = Paths.get("/home/java");
        Path absolute2 = Paths.get("/usr/local");
        Path absolute3 = Paths.get("/home/java/temp/music.mp3");
        Path relative1 = Paths.get("temp");
        Path relative2 = Paths.get("temp/music.pdf");
        System.out.println("1: " + absolute1.relativize(absolute3));
        System.out.println("2: " + absolute3.relativize(absolute1));
        System.out.println("3: " + absolute1.relativize(absolute2));
        System.out.println("4: " + relative1.relativize(relative2));
        System.out.println("5: " + absolute1.relativize(relative1));    // BAD - can't make a relative path out of 1 absolute and one relative path

//        1: temp/music.mp3
//        2: ../..
//        3: ../../usr/local
//        4: music.pdf
//        Exception in thread "main" java.lang.IllegalArgumentException: 'other' is different type of Path
//        at sun.nio.fs.UnixPath.relativize(UnixPath.java:416)
//        at sun.nio.fs.UnixPath.relativize(UnixPath.java:43)
//        at Chapter5_IO_and_NIO.RelativizePath.main(RelativizePath.java:26)

        // relativize and resolve are opposites
        // relativize also doesn't check if the path exists
    }
}
