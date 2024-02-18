package Chapter6_Generics_and_Collections.Using_Collections;

import java.sql.SQLOutput;

public class BoxingWatchForNull {
    static Integer x;
    static int y;

    public static void main(String[] args) {
        doStuff(y);     // this works as int default to 0
        doStuff(x);     // will pass null
    }

    private static void doStuff(int z) {
        int z2 = 5;
        System.out.println(z2 + z);         // NullPointerException when z is null (i.e. when x was passed into the function)
    }
}

// The code compiles fine but there will be a runtime NullPointer Exception at line 14
// when z is "unboxed" it will be null (because x has not be initialised)
