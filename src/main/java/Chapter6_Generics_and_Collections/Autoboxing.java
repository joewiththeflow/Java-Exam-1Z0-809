package Chapter6_Generics_and_Collections;

public class Autoboxing {
    public static void main(String[] args) {
        Integer y = new Integer(567);
        int x = y.intValue();
        x++;
        y = new Integer(x);
        System.out.println(x);

        // As of Java 5, you can say:
        Integer a = new Integer(567);
        a++;
        System.out.println(a);
    }
}

// It looks as though you are incrementing an object, "a", but it's actually just for convenience
// The compiler is doing the unboxing and reassignment for you

// An important thing to remember is that when "a" appears to increment, it is a new Integer that is created
// Integers are immutable
