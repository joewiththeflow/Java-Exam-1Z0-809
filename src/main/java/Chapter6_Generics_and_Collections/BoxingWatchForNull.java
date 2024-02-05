package Chapter6_Generics_and_Collections;

import java.sql.SQLOutput;

public class BoxingWatchForNull {
    static Integer x;

    public static void main(String[] args) {
        doStuff(x);
    }

    private static void doStuff(int z) {
        int z2 = 5;
        System.out.println(z2 + z);
    }
}

// The code compiles fine but there will be a runtime NullPointer Exception at line 14
// when z is "unboxed" it will be null (because x has not be initialised)
