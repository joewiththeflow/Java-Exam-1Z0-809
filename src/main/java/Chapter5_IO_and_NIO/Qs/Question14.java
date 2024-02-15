package Chapter5_IO_and_NIO.Qs;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Question14 {

//    Assume all the files referenced by these paths exist:

    Path a = Paths.get("c:/temp/dir/a.txt");
    Path b = Paths.get("c:/temp/dir/subdir/b.txt");

//    What is the correct PathMatcher to match both these files?

//    A. "glob:*/*.txt"         ---> would match "temp" but not "c:/temp"
//    B. "glob:**.txt"          ---> CORRECT as ** matches zero or more characters, including multiple directories
//    C. "glob:*.txt"
//    D. "glob:/*/*.txt"        ----> path we are after doesn't begin with a /
//    E. "glob:/**.txt"         ----> path we are after doesn't begin with a /
//    F. "glob:/*.txt"          ----> path we are after doesn't begin with a /
//    G. None of the above
}
