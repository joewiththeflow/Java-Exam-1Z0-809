package Chapter7_Inner_Classes;

public class MyWonderfulClass {

    void go() {
        Bar b = new Bar();
//        Below comment is how to make anonymous inner class (interface)
//        b.doStuff(new Foo() {
//            @Override
//            public void foof() {
//                System.out.println("foofy");
//            }
//        });
        b.doStuff(() -> System.out.println("foofy"));   // using a lambda instead
        Foo f = () -> System.out.println("foofy 2");    // more explicit
        b.doStuff(f);
    }

    public static void main(String[] args) {
        new MyWonderfulClass().go();
    }
}

interface Foo {
    void foof();
}

class Bar {
    void doStuff(Foo f) {
        f.foof();
    }
}
