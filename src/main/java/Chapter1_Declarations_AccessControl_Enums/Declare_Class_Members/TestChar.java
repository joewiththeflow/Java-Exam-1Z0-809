package Chapter1_Declarations_AccessControl_Enums.Declare_Class_Members;

public class TestChar {
    public static void main(String[] args) {
        char x = 'x';
        short y = (short) x;    // You need to cast to short - technically a short can't hold all unicode chars as its signed
        int z = x;
        long a = x;

        System.out.println(x);
        System.out.println(y);
        System.out.println(z);
        System.out.println(a);

        char b = (char) (x + 1);    // you can add a number to a cha but need to cast result to char

        final int c;
        c = 10;
    }
}
