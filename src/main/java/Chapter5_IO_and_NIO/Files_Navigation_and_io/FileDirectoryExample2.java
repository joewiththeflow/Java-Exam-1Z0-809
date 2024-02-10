package Chapter5_IO_and_NIO.Files_Navigation_and_io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileDirectoryExample2 {
    public static void main(String[] args) {
        File myDir2 = new File("mydir2");
        // myDir2.mkdir()                           // call to mkdir() omitted
        File myFile = new File(myDir2, "MyFile.txt");
        try {
            myFile.createNewFile();     // This will generate an exception if the call to mkdir() has not been made!!!
        }
        catch (IOException e) {
            System.out.println(e);      // java.io.IOException: No such file or directory
        }

        // Therefore, although a file which does not exist will be created by a Writer or a Stream,
        // the same is not true for directories

        File myDir3 = new File("mydir3");
        myDir3.mkdir();

        // Existing directory
        System.out.println(myDir3.isDirectory());

        File myDir3File = new File(myDir3, "myDir3File.txt");   // assign a file
        System.out.println(myDir3File.isFile());

        try {
            FileReader fr = new FileReader(myDir3File);
            BufferedReader br = new BufferedReader(fr);             // Mak a Reader

            String s;
            while ( (s = br.readLine()) != null) {                  // read data
                System.out.println(s);
            }

            br.close();         // notice there is no flush ()
                                // When READING a file, no flushing is required!

        } catch (IOException e) { }


    }
}
