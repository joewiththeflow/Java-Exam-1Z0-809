package Chapter5_IO_and_NIO.Serialization;

import java.io.*;
import java.sql.SQLOutput;

public class Cat implements Serializable {      // has to implement Serializable

    private String name = "Mittens";
    public static void main(String[] args) {

        Cat c = new Cat();
        Cat d;

        try {
            FileOutputStream fos = new FileOutputStream("src/main/java/Chapter5_IO_and_NIO/Serialization/catSerialized.txt");
            ObjectOutputStream os = new ObjectOutputStream(fos);
            os.writeObject(c);
            os.close();
        } catch (IOException e) {}

        try {
            FileInputStream fis = new FileInputStream("src/main/java/Chapter5_IO_and_NIO/Serialization/catSerialized.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            d = (Cat) ois.readObject();
            System.out.println("Cat's name is " + d.name);
            ois.close();
        } catch (Exception e) {}

    }
}
