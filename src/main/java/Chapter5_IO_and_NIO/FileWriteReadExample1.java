package Chapter5_IO_and_NIO;

import java.io.*;

public class FileWriteReadExample1 {
    public static void main(String[] args) {
        char[] in = new char[50];                               // to store input
        int size = 0;
        try {
            File file = new File("fileWrite2.txt");   // just an object
            FileWriter fw = new FileWriter(file);               // create an actual file and FileWriter object
            fw.write("howdy\nfolks\n");                      // write characters to the file
            fw.flush();                                         // flush before closing
            fw.close();

            FileReader fr = new FileReader(file);               // create a FileReader object
            size = fr.read(in);                                 // read whole file!
            System.out.print("size: " + size + " ");
            for(char c : in)
                System.out.print(c);
            fr.close();

        } catch (IOException e){ }
    }
}
