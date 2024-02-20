package Chapter7_Inner_Classes.Anonymous_Inner_Classes;

public class Popcorn {
    public void pop() {
        System.out.println("popcorn");
    }

    public static void main(String[] args) {
        new Popcorn().pop();
        new Food().p.pop();
    }
}

class Food {
    public Popcorn p = new Popcorn() {                  // --> This is actually creating an anonymous subclass of Popcorn
        public void sizzle() {                                  // Legal but you can't actually us it, Popcorn reference
                                                                // has no method sizzle()
            System.out.println("anonymous sizzling popcorn");
        }
        @Override
        public void pop() {
            System.out.println("anonymous popcorn");
        }
    };
    public void popIt() {
        p.pop();
//        p.sizzle();                                     // Not legal! Popcorn does not have a sizzle method
    }
}


