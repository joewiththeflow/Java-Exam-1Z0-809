package Chapter5_IO_and_NIO.Files_Navigation_and_io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileDirectoryExample1 {
    public static void main(String[] args) {

        File myDir = new File("mydir");     // create a File object
        myDir.mkdir();                               // make an actual directory on file system
                                                    // Interestingly, does not need try/catch

        // Create a new file in the new directory
        File myFile = new File("mydir", "myFile.txt");      // create File object
        // need try catch for any attempt to create a new file
        try {
            myFile.createNewFile();         // actually create a new file in the directory

            // You could then write to the new file using a PrintWriter
            // So it appears that you can just provide a File object to the PrintWriter
            // You can, but do not need to actually provide an object which conforms to Writer e.g. FileWriter in the constructor
            PrintWriter pw = new PrintWriter(myFile);
            pw.println("new stuff");
            pw.flush();
            pw.close();

            // The problem with PrintWriter is that if the file exists, it will truncate the size of it to zero
            // What you can do is check whether the file exists first, and create a PrintWriter with a FileWriter
            // With a FileWriter, you have the option to append to the File rather than overwrite
            PrintWriter pw2 = null;
            if (myFile.exists() && !myFile.isDirectory()) {
                pw2 = new PrintWriter(new FileWriter(myFile, true));
            } else {
                pw2 = new PrintWriter(myFile);
            }

            pw2.append("hello");
            pw2.flush();
            pw2.close();
        }
        catch(IOException e) { }


    }
}
