package Chapter5_IO_and_NIO;

import java.io.File;

public class SearchExample1 {
    public static void main(String[] args) {
        String[] files = new String[100];
        File search = new File("searchThis");
        files = search.list();          // create list of dirs/files inside "searchThis" dir

        for (String fn: files) {
            System.out.println("found " + fn);
        }

        // Will print:
//        found file2.txt
//        found file1.txt
//        found dir2
//        found dir3
//        found dir1


        // Therefore will not search subdirectories for files as well
    }

}
