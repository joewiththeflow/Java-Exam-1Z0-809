package Chapter5_IO_and_NIO.Qs;
import java.io.*;

class Player {
    Player() {
        System.out.println("p");
    }
}
public class Question17 extends Player implements Serializable {
    Question17() {
        System.out.println("c");
    }

    public static void main(String[] args) {
        Question17 c1 = new Question17();
        try {
            FileOutputStream fos = new FileOutputStream("src/main/java/Chapter5_IO_and_NIO/Qs/question17/play.txt");
            ObjectOutputStream os = new ObjectOutputStream(fos);
            os.writeObject(c1);
            os.close();
            FileInputStream fis = new FileInputStream("src/main/java/Chapter5_IO_and_NIO/Qs/question17/play.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Question17 c2 = (Question17) ois.readObject();
            ois.close();
        } catch (Exception x) { }
    }

}

//What is the result?

// A. pc
// B. pcc
// C. pcp   --> CORRECT (Player isn't Serializable so a call to its constructor will be made)
// D. pcpc
// E. Compilation fails
// F. An exception is thrown at runtime
