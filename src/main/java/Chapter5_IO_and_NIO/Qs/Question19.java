package Chapter5_IO_and_NIO.Qs;
import java.io.*;
public class Question19 {
    public static void main(String[] args) {
        SpecialSerial s = new SpecialSerial();
        try {
            ObjectOutputStream os = new ObjectOutputStream(
                    new FileOutputStream("src/main/java/Chapter5_IO_and_NIO/Qs/question18/myFile")
            );
            os.writeObject(s);
            os.close();
            System.out.print(++s.z + " ");

            ObjectInputStream ois = new ObjectInputStream(
                    new FileInputStream("src/main/java/Chapter5_IO_and_NIO/Qs/question18/myFile")
            );
            SpecialSerial s2 = (SpecialSerial) ois.readObject();
            ois.close();
            System.out.println(s2.y + " " + s2.z);
        } catch (Exception x) {
            System.out.println("exc");
        }
    }
}

class SpecialSerial implements Serializable {
    transient int y = 7;
    static int z = 9;
}

// Which are true?

// A. Compilation fails
// B. The output is 10 0 9
// C. The output is 10 0 10     ---> CORRECT
// D. The output is 10 7 9
// E. The output is 10 7 10
// F. In order to alter the standard deserialisation process, you would implement the readObject() method in SpecialSerial   ---> CORRECT
// G. In order to alter the standard deserialisation process, you would implement the defaultReadObject() method in SpecialSerial
