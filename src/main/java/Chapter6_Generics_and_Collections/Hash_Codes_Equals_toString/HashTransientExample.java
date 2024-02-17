package Chapter6_Generics_and_Collections.Hash_Codes_Equals_toString;

import java.io.*;
import java.sql.SQLOutput;
// The lesson here is that you should never use transient values as part of an equals or hashcode method as transient
// variables will revert to their default values when object is deserialized.
// This could mean that an object which should be regarded as equal will not be recognised to be so, which could lead to
// for example:
//   - If you were to use an object as the key for a HashMap
//   - When you attempt to use the deserialized object, the hashcode will be different (calculation depends on vx variable value)
//   - Therefore the HashMap will be looking in a different 'bucket' for the object key

public class HashTransientExample {
    public static void main(String[] args) {
        SaveMe initial = new SaveMe(3, 11);
        try {
            // Serialize
            ObjectOutputStream os = new ObjectOutputStream(
                    new FileOutputStream("src/main/java/Chapter6_Generics_and_Collections/Hash_Codes_Equals_toString/saveme.txt")
            );
            os.writeObject(initial);
            // Deserialize
            ObjectInputStream ois = new ObjectInputStream(
                    new FileInputStream("src/main/java/Chapter6_Generics_and_Collections/Hash_Codes_Equals_toString/saveme.txt")
            );
            SaveMe after = (SaveMe) ois.readObject();
            // Equals and hashcode values
            System.out.println("Initial's values (before serialization): " + initial);
            System.out.println("initial.equals(initial): " + initial.equals(initial));
            System.out.println("initial.hashcode(): " + initial.hashcode());
            System.out.println("After's values (after deserialization): " + after);
            System.out.println("initial.equals(after): " + initial.equals(after));
            System.out.println("after.hashcode(): " + after.hashcode());
        } catch (Exception x) { }
    }
}

class SaveMe implements Serializable {
    transient int x;                    // This will be set to 0 by default when the object is deserialized
                                        // Therefore if you sue it in either equals() or hashcode() methods,
                                        // 2x object which should match will not
    int y;
    SaveMe(int xVal, int yVal) {
        x = xVal;
        y = yVal;
    }
    public int hashcode() {
        return (x ^ y);         // Legal, but not correct to use a transient variable
    }
    public boolean equals(Object o) {
        SaveMe test = (SaveMe) o;
        if (test.y == y && test.x == x) {       // Legal, not correct
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "SaveMe{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
