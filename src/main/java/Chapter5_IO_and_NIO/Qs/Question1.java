package Chapter5_IO_and_NIO.Qs;

import java.io.File;

public class Question1 {
//    1.   Note: The use of “drag-and-drop” questions has come and gone over the years. In case Oracle brings them back into fashion,
//    we threw a couple of them in the book. Using the fewest fragments possible (and filling the fewest slots possible),
//    complete the following code so that the class builds a directory named “dir3” and creates a file named “file3” inside “dir3.”
//    Note you can use each fragment either zero or one times.
//
//    Code:
//    import java.io.___________________
//
//    class Maker {
//        public static void main(String[] args) {
//            ________  ___________  ___________
//            ________  ___________  ___________
//            ________  ___________  ___________
//            ________  ___________  ___________
//            ________  ___________  ___________
//            ________  ___________  ___________
//            ________  ___________  ___________
//            ________  ___________  ___________
//        }
//    }
//
//
//
//    Fragments:
//      File;       FileDescriptor;         FileWriter          Directory;
//        try {       .createNewDir();        File dir          File
//      { }         (Exception x)           ("dir3");           file
//      file        .createNewFile();       = new File          = new File
//      dir         ("dir", "file3");       (dir, file);        .createFile();
//      } catch     ("dir3", "file3");      .mkdir();           File file

    public static void main(String[] args) {
        File dir = new File("dir3");
        dir.mkdir();
        File file = new File("dir3","file3");
        try {
            file.createNewFile();
        } catch (Exception x) { }
    }
}
