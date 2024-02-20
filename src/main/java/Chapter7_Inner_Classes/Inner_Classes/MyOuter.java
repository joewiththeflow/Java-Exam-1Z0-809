package Chapter7_Inner_Classes.Inner_Classes;

public class MyOuter {
    private int x = 7;

    public void makeInner() {
        MyInner in = new MyInner();
        in.seeOuter();
    }
    class MyInner {

        public void seeOuter() {
            System.out.println("Outer x is " + x);
            System.out.println("Inner class ref is " + this);
            System.out.println("Outer class ref is " + MyOuter.this);
        }
    }

    public static void main(String[] args) {
        MyOuter.MyInner mo2 = new MyOuter().new MyInner();
//        MyOuter.MyInner mo3 = new MyInner();          // main method, but static so it is not from within the class instance

    }
}
