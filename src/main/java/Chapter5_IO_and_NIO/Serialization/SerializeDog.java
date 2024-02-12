package Chapter5_IO_and_NIO.Serialization;

import java.io.*;

// In this example, we want to serialize a Dog object
// However, the Dog object contains a Collar object reference
// Therefore we have to make the Collar object serializable too and Java will automate the serialization
// Produces:
    //before: collar size is 3
    //after: collar size is 3
public class SerializeDog {
    public static void main(String[] args) {
        Collar c = new Collar(3);
        Dog d = new Dog(c, 5);
        System.out.println("before: collar size is " + d.getCollar().getCollarSize());

        try {
            FileOutputStream fs = new FileOutputStream("src/main/java/Chapter5_IO_and_NIO/Serialization/dogCollarSerialized.txt");
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(d);          // write object
            os.close();
        } catch (IOException e) {}
        try {
            FileInputStream fis = new FileInputStream("src/main/java/Chapter5_IO_and_NIO/Serialization/dogCollarSerialized.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            d = (Dog) ois.readObject();             // read, remember we need to cast the object
            ois.close();
        } catch (IOException | ClassNotFoundException e) {}
        System.out.println("after: collar size is " + d.getCollar().getCollarSize());
    }
}

class Dog implements Serializable {
    private Collar theCollar;
    private int dogSize;
    public Dog(Collar collar, int size) {
        theCollar = collar;
        dogSize = size;
    }
    public Collar getCollar() { return theCollar; }
}

class Collar implements Serializable {
    private int collarSize;
    public Collar (int size) { collarSize = size; }
    public int getCollarSize() { return collarSize; }
}
