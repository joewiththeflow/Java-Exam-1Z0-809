package Chapter7_Inner_Classes.Inner_Classes;

import Chapter7_Inner_Classes.Inner_Classes.MyOuter;

public class Main {
    public static void main(String[] args) {
        MyOuter mo = new MyOuter();
        MyOuter.MyInner inner = mo.new MyInner();
        inner.seeOuter();

        // or
        MyOuter.MyInner inner2 = new MyOuter().new MyInner();
        inner2.seeOuter();
    }

}
