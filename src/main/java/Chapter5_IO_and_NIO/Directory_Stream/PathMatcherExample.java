package Chapter5_IO_and_NIO.Directory_Stream;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;

public class PathMatcherExample {
    public static void main(String[] args) {
        Path path1 = Paths.get("searchThis/dir4/dir5.txt");
        Path path2 = Paths.get("dir5.txt");

        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*.txt");
        // an "*" means match any character except for a directory boundary
        // two "**" means any character including a directory boundary

        System.out.println(matcher.matches(path1));     // False
        System.out.println(matcher.matches(path2));     // True

        System.out.println("****");
        Path path3 = Paths.get("/com/java/One.java");
        matches(path3, "glob:*.java");                      // false
        matches(path3, "glob:**/*.java");                   // true
        matches(path3, "glob:*");                           // false
        matches(path3, "glob:**");                          // true

        System.out.println("****");
        Path path4 = Paths.get("com\\java\\One.java");
        matches(path4, "glob:*.java");                      // true
        matches(path4, "glob:**/*.java");                   // false
        matches(path4, "glob:*");                           // true
        matches(path4, "glob:**");                          // true

        // IMPORTANT, path 4 is like this on UNIX machines as it does not recognise the slashes as directory boundaries
        // Always try to use "/" so your code performs predictably on both OS's
        // On windows it would be:
        // false
        // true
        // false
        // true

        System.out.println("****");
        // "?" let you match a specific character:
        Path path5 = Paths.get("One.java");
        Path path6 = Paths.get("One.ja^a");
        matches(path5, "glob:*.????");              // true
        matches(path5, "glob:*.???");               // false
        matches(path6, "glob:*.????");              // true
        matches(path6, "glob:*.???");               // false


        System.out.println("****");
        // "{}" allow multiple patterns
        Path path7 = Paths.get("Bert-book");
        Path path8 = Paths.get("Kathy-horse");
        matches(path7, "glob:{Bert*,Kathy*}");         // true
        matches(path8, "glob:{Bert,Kathy}*");          // true      // can share wildcards outside braces
        matches(path7, "glob:{Bert,Kathy}");          // false


        // Tricky example
        // [0-9] - any one character from 0 to 9
        // \\* - literal "*" rather than wildcard. The "\" escapes the "*" but you need to escape the "\" with another "\"
        // {A*,b} - Either a capital "A" followed by anything or the single character "b"
        // /**/ - One or more directories with any name
        // 1 - the single character "1"
        Path path9 = Paths.get("0*b/test/1");
        Path path10 = Paths.get("9\\*b/test/1");            // "\\*" rather than what will be looked for in glob: "*"
        Path path11 = Paths.get("01b/test/1");              // no literal "*"
        Path path12 = Paths.get("0*b/1");                   // no directory between "b" and "1", glob expects at least one
        String glob = "glob:[0-9]\\*{A*,b}/**/1";
        matches(path9, glob);                           // true
        matches(path10, glob);                          // false
        matches(path11, glob);                          // false
        matches(path12, glob);                          // false

        // What to match                                            Glob            Regex
        // Zero or more of any char including directory             **              .*
        // Zero or more of any char, not including directory        *               N/A no special syntaz
        // Exactly one char                                         ?               .
        // Any digit                                                [0-9]           [0-9]
        // Begins with cat or dog                                   {cat, dog}*     (cat|dog).*

    }

    public static void matches(Path path, String glob) {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher(glob);
        System.out.println(matcher.matches(path));
    }

}
