package Chapter7_Inner_Classes;

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
    public Popcorn p = new Popcorn() {
        @Override
        public void pop() {
            System.out.println("anonymous popcorn");
        }
    };
}


