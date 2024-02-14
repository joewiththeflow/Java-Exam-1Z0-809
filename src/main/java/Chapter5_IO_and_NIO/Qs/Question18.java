package Chapter5_IO_and_NIO.Qs;
import java.io.*;

class Keyboard { }

public class Question18 implements Serializable {
    private Keyboard k = new Keyboard();
    public static void main(String[] args) {
        Question18 c = new Question18();
        c.storeIt(c);
    }
    void storeIt(Question18 c) {
        try {
            ObjectOutputStream os = new ObjectOutputStream(
                    new FileOutputStream("src/main/java/Chapter5_IO_and_NIO/Qs/question18/myFile")
            );
            os.writeObject(c);
            os.close();
            System.out.println("done");
        } catch (Exception x) {
            System.out.println("exc");
        }
    }
}

// What is the result? (Choose all that apply)

// A. exc                                   --> CORRECT, k not marked as transient
// B. done
// C. Compilation fails
// D. Exactly one object serialized
// E. Exactly two objects are serialized

