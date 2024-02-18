package Chapter6_Generics_and_Collections.Using_Collections;

public class Autoboxing {
    public static void main(String[] args) {
        // Pre Java 5, you have to wrap, unwrap, use, rewrap etc.
        Integer y = new Integer(567);   // make
        int x = y.intValue();                 // unwrap
        x++;                                  // use
        y = new Integer(x);                   // rewrap
        System.out.println(x);

        // As of Java 5, you can say:
        Integer a = new Integer(567);   // make
        a++;                                  // unwrap, use, rewrap
        System.out.println(a);
    }
}

// It looks as though you are incrementing an object, "a", but it's actually just for convenience
// The compiler is doing the unboxing and reassignment for you

// An important thing to remember is that when "a" appears to increment, it is a new Integer that is created
// Integers are immutable
