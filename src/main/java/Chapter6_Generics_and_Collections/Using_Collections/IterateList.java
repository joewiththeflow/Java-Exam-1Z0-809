package Chapter6_Generics_and_Collections.Using_Collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Dog {
    public String name;
    Dog(String n) { name=n; }
}
public class IterateList {
    public static void main(String[] args) {
        List<Dog> d = new ArrayList<>();
        Dog dog = new Dog("aiko");
        d.add(dog);
        d.add(new Dog("clover"));
        d.add(new Dog("magnolia"));
        Iterator<Dog> i3 = d.iterator();            // make an iterator using generics syntax
        // We could have created the above line using:
        // Iterator i3 = d.iterator(); - But we would then have to cast the Object returned by next() to a Dog
        // e.g. Dog d2 = (Dog) i3.next();
        while(i3.hasNext()) {
            Dog d2 = i3.next();                     // cast not required
            System.out.println(d2.name);
        }
        System.out.println("size " + d.size());
        System.out.println("get1 " + d.get(1).name);
        System.out.println("aiko " + d.indexOf(dog));
        d.remove(2);
        Object[] oa = d.toArray();
        for (Object o : oa) {
            Dog d2 = (Dog) o;
            System.out.println("oa " + d2.name);
        }
    }
}
