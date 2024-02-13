package Chapter5_IO_and_NIO.Qs;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Question7 {

//    Give a directory tree at the root of the C: drive and the fact that no other files exist:

//    dir x - |
//    ...........| - dir y
//    ...........| - file a

//    and these two paths:
public static void main(String[] args) {
    Path one = Paths.get("c:/x");
    Path two = Paths.get("c:/x/y/a");

//    Which of the following statements prints out: y/a ?

//    A.
    System.out.println(one.relativize(two));      // ---> CORRECT
//    B.
    System.out.println(two.relativize(one));
//    C.
    System.out.println(one.resolve(two));
//    D.
    System.out.println(two.resolve(one));
//    E.
    System.out.println(two.resolve(two));
//    F. None of the above
}

}
