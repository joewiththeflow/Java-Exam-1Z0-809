package Chapter6_Generics_and_Collections.Using_Collections;

import java.util.HashMap;
import java.util.Map;

class Dog2 {
    String name;
    public Dog2(String n) { name = n; }

    @Override
    public boolean equals(Object obj) {
        if((obj instanceof Dog2) && (((Dog2) obj).name == name)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return name.length();
    }
}

class Cat { }

enum Pets {DOG, CAT, HORSE}         // enum overrides equals() and hashcode() methods so can be used as HashMap key

public class HashMapExample {
    public static void main(String[] args) {
        Map<Object, Object> m = new HashMap<Object, Object>();

        m.put("k1", new Dog2("aiko"));       // add some key/value pairs
        m.put("k2", Pets.DOG);
        m.put("k2", Pets.HORSE);                // just an example of updating the existing value for a key
        m.put(Pets.CAT, "CAT.key");
        Dog2 d1 = new Dog2("clover");         // keep a reference to this one
        m.put(d1, "Dog key");
        m.put(new Cat(), "Cat key");

        System.out.println(m.get("k1"));        // returns Dog instance
        String k2 = "k2";
        System.out.println(m.get(k2));          // returns DOG enum value
        Pets p = Pets.CAT;
        System.out.println(m.get(p));           // returns "CAT.key"
        System.out.println(m.get(d1));          // returns "Dog key"
        System.out.println(m.get(new Cat()));   // returns null - Cat class does not override equals() and hashcode()
        System.out.println(m.size());           // 5

        // Changing the name of the instance of Dog will change the hashcode, meaning it can no longer be found
        d1.name = "magnolia";
        System.out.println(m.get(d1));      // null
                                            // hashcode doesn't match so will not look in correct bucket

        d1.name = "clover";
        System.out.println(m.get(new Dog2("clover")));      // prints: "Dog key"
                                                                // hashcode matches
                                                                // equals method matches
        d1.name = "arthur";
        System.out.println(m.get(new Dog2("clover")));      // null
                                                            // hashcode matches so will look in correct bucket
                                                            // equals method won't match as based on name

    }



}
