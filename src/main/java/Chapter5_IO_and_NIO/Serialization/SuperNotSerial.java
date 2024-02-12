package Chapter5_IO_and_NIO.Serialization;

import java.io.*;
// If a superclass is not serializable, the constructor for that class is run during deserialization
// Any variables which are initialized in the superclass will be set, rather than what that value might have been in a serialized object
// In the below example, a Dog3 object is created with a weight of 35 and serialized
// When deserialized, the name (which is part of the Dog3) is deserialized successfully
// However, the weight comes from Animal which is not serializable, and therefore Animal's constructor is run
// and any variables that are initialized are set to the value that they are initialized to
// Produces:
    //before: Fido 35
    //after: Fido 42
public class SuperNotSerial {
    public static void main(String[] args) {

        Dog3 d = new Dog3(35, "Fido");
        System.out.println("before: " + d.name + " " + d.weight);
        try {
            FileOutputStream fs = new FileOutputStream("src/main/java/Chapter5_IO_and_NIO/Serialization/DogSerialization.txt");
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(d);
            os.close();
        } catch (Exception e) {}
        try {
            FileInputStream fis = new FileInputStream("src/main/java/Chapter5_IO_and_NIO/Serialization/DogSerialization.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            d = (Dog3) ois.readObject();
            ois.close();
        } catch (IOException | ClassNotFoundException e) {}

        System.out.println("after: " + d.name + " " + d.weight);
    }
}

class Dog3 extends Animal implements Serializable {
    String name;
    Dog3(int w, String n) {
        weight = w;             // weight inherited variable
        name = n;
    }
}
class Animal {          // not serializable!!!
    int weight = 42;
}
