package Chapter5_IO_and_NIO.Files_Navigation_and_io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class FileInputStreamFileOutputStreamExample1 {
    public static void main(String[] args) {
        byte[] in = new byte[50];
        int size = 0;
        FileOutputStream fos = null;
        FileInputStream fis = null;
        File file = new File("fileWrite3.txt");
        try {
            fos = new FileOutputStream(file);               // IF FILE EXISTS IT WILL CREATE NEW BLANK FILE !!!!!
            String s = "howdy\nfolks\n";
            fos.write(s.getBytes(StandardCharsets.UTF_8));
            fos.flush();
            fos.close();

            fis = new FileInputStream(file);
            size = fis.read(in);
            System.out.print("size: " + size + " ");
            for(byte b : in) {
                System.out.print((char)b);
            }
        } catch (IOException e) { }
    }
}
