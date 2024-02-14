package Chapter5_IO_and_NIO.Qs;
import java.io.*;
public class Question19 {
    public static void main(String[] args) {

    }
}

class SpecialSerial implements Serializable {
    transient int y = 7;
    static int z = 7;
}
