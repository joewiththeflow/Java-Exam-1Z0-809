package Chapter5_IO_and_NIO.Serialization;

import java.io.*;

// What happens when an object which is referenced is not Serializable?
// you can mark the reference to the object as 'transient',
// however if you leave it there you will end up with a NullPointerException when you try to read the Dog back in
// The solution is to use special methods called 'writeObject' and readObject'
// If these are present, you can jump in at the point  of serialization by adding an int to represent the state of the Collar variable,
// then you can jump in at the point of deserialization and use that int to create a new Collar
// Produces:
    //before: collar size is 3
    //after: collar size is 3
public class writeObjectreadObjectExample {
    public static void main(String[] args) {
        Collar2 c = new Collar2(3);
        Dog2 d = new Dog2(c, 5);
        System.out.println("before: collar size is " + d.getCollar().getCollarSize());

        try {
            FileOutputStream fs = new FileOutputStream("src/main/java/Chapter5_IO_and_NIO/Serialization/dogCollarSerialized2.txt");
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(d);          // write object
            os.close();
        } catch (IOException e) {}
        try {
            FileInputStream fis = new FileInputStream("src/main/java/Chapter5_IO_and_NIO/Serialization/dogCollarSerialized2.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            d = (Dog2) ois.readObject();             // read, remember we need to cast the object
            ois.close();
        } catch (IOException | ClassNotFoundException e) {}
        System.out.println("after: collar size is " + d.getCollar().getCollarSize());
    }
}

class Dog2 implements Serializable {
    private transient Collar2 theCollar;        // note the 'transient' keyword
    private int dogSize;
    public Dog2(Collar2 collar, int size) {
        theCollar = collar;
        dogSize = size;
    }
    public Collar2 getCollar() { return theCollar; }
    private void writeObject(ObjectOutputStream os) {
        try {
            os.defaultWriteObject();                        // do the normal serialization
            os.writeInt(theCollar.getCollarSize());         // add an int to the stream thats creating a serialized Dog2
                                                            // you can read stuff before and/or after you invoke defaultWriteObject()
                                                            // but you must read it back in the same order
        } catch (Exception e) {}
    }
    private void readObject(ObjectInputStream is) {
        try {
            is.defaultReadObject();                         // handle the normal deserialization
            theCollar = new Collar2(is.readInt());          // Build a new Collar object using readInt
                                                            // this also ensures the stream is in sync
        } catch (Exception e) {}
    }


}

class Collar2 {                                     // no longer implements Serializable
    private int collarSize;
    public Collar2 (int size) { collarSize = size; }
    public int getCollarSize() { return collarSize; }

}
