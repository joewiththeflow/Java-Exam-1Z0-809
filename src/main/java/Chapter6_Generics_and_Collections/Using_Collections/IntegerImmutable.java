package Chapter6_Generics_and_Collections.Using_Collections;

public class IntegerImmutable {
    public static void main(String[] args) {
        Integer y = 567;
        Integer x = y;

        System.out.println(y==x);       // both refer to saem Integer object

        y++;                                // unwrap, use, rewrap (new Integer)
        System.out.println(x + " " + y);

        System.out.println(y==x);       // verify they refer to different objects
    }
}
