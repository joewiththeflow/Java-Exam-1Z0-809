package Chapter6_Generics_and_Collections;

public class BoxingEquals {
    public static void main(String[] args) {
        Integer i1 = 1000;
        Integer i2 = 1000;
        if(i1 != i2) System.out.println("different objects");
        if(i1.equals(i2)) System.out.println("meaningfully equal");

        Integer i3 = 10;
        Integer i4 = 10;
        if(i3 == i4) System.out.println("same object");
        if(i3.equals(i4)) System.out.println("meaningfully equal");
    }
}

// This is a tricky one. In order to save memory, two instances of the following wrapper objects (created through boxing)
// will always be == whent heir primitive values are the same:

//    - Boolean
//    - Byte
//    - Character from \u0000 to \u007f (7f is 127 in decimal)
//    - Short and Integer from -128 to 127