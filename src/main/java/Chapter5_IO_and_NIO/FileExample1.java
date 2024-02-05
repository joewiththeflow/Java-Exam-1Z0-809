package Chapter5_IO_and_NIO;
import java.io.*;

public class FileExample1 {
    public static void main(String[] args) {
        try {
            boolean newFile = false;
            File file = new File("fileWrite1.txt");
            System.out.println(file.exists());
            newFile = file.createNewFile();         // returns true if new file created, false if file already exists
            System.out.println(newFile);
            System.out.println(file.exists());
        } catch (IOException e) { }
    }
}
