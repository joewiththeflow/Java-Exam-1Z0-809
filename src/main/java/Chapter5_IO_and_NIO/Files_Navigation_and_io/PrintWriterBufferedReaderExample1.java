package Chapter5_IO_and_NIO.Files_Navigation_and_io;

import java.io.*;

public class PrintWriterBufferedReaderExample1 {
    public static void main(String[] args) {
        // As you're not creating a file on the file system, you don't need try/catch
        File file = new File("fileWrite4.txt");     // create a File object

        // Need try catch as soon as you pass a File object to a Writer as it will attempt to create the file on the file system
        try {
            FileWriter fw = new FileWriter(file);            // create a FileWriter object
                                                            // But it also creates the empty file on system if it doesn't exist

            // NOTE - I've actually tested and FileWriter will clear the contents of an existing file
            // What you can do is actually pass in a second boolean argument to say that you wish to append to the end of the file
            // For example you could use the below:
//            FileWriter fw = new FileWriter(file, true);

            // Use a PrintWriter as it is a very easy way to write one line at a time, rather than including newline characters in text
            PrintWriter pw = new PrintWriter(fw);           // pass in the FileWriter
                                                            // PrintWriter will send its output to the FileWriter
            pw.println("howdy");
            pw.println("folks");

            // unsure if closing PrintWriter also closes FileWriter so just calling FileWriter close
            pw.close();
            fw.close();

            // READ the file
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String data = br.readLine();    // get the first line or return null if no more lines

            while(data != null) {        // only print out the line if it is not empty
                System.out.println(data);
                data = br.readLine();       // get next line
            }

        } catch(IOException e) { }
    }
}
