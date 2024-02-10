package Chapter5_IO_and_NIO;

import java.nio.file.Path;
import java.nio.file.Paths;

public class NormalizePath {
    public static void main(String[] args) {
        // All 3 of the below represent the same path:
        Path p1 = Paths.get("myDirectory");
        Path p2 = Paths.get("./myDirectory");   // "./" means current directory
        Path p3 = Paths.get("anotherDirectory","..", "myDirectory");    // ".." means go up on directory


        // Scenario where you might want to use a script that can then build a path to source files before compile
        // Just an example to highlight how it could be built from variables
        String buildProject = "/Build_Project/scripts";
        String upTwoDirectories = "../..";
        String myProject = "/My_Project/source";
        Path path = Paths.get(buildProject, upTwoDirectories, myProject);    // build path from variables

        System.out.println("Original: " + path);
        // Original: /Build_Project/scripts/../../My_Project/source
        System.out.println("Normalized: " + path.normalize());
        // Normalized: /My_Project/source

        // REMEMBER that normalize doesn't actually check if the directory/file exists or not

        System.out.println(Paths.get("/a/./b/./c").normalize());
        System.out.println(Paths.get(".classpath").normalize());
        System.out.println(Paths.get("/a/b/c/..").normalize());
        System.out.println(Paths.get("../a/b/c").normalize());  // THIS one starts with "../" so can't be simplified!!!

        // produces:
        // /a/b/c
        // .classpath
        // /a/b
        // ../a/b/c
    }


}
