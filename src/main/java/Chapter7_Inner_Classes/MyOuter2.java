package Chapter7_Inner_Classes;

public class MyOuter2 {
    private String x = "Outer2";

    void doStuff() {
        final String z = "local variable";
        class MyInner {
            public void seeOuter() {
                System.out.println("Outer x is " + x);
                System.out.println("Local var z is " + z);
                //z = "changing the local variable" ;     // won't compile
            }
        }
        x = "changing Outer2";

        MyInner mi = new MyInner();
        mi.seeOuter();
    }

    public static void main(String[] args) {
        MyOuter2 mo2 = new MyOuter2();
        mo2.doStuff();
    }
}
