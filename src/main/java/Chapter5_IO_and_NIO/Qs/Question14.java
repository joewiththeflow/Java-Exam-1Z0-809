package Chapter5_IO_and_NIO.Qs;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Question14 {

//    Assume all the files referenced by these paths exist:

    Path a = Paths.get("c:/temp/dir/a.txt");
    Path b = Paths.get("c:/temp/dir/subdir/b.txt");

//    What is the correct PathMatcher to match both these files?

//    A. "glob:*/*.txt"
//    B. "glob:**.txt"
//    C. "glob:*.txt"
//    D. "glob:/*/*.txt"
//    E. "glob:/**.txt"
//    F. "glob:/*.txt"
//    G. None of the above          ---> CORRECT should be something like "glob:**/*.txt"
}
