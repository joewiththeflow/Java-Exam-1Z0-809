package Chapter7_Inner_Classes.Anonymous_Inner_Classes;

public interface Cookable {
    public void cook();

    public static void main(String[] args) {
        new Food2().c.cook();
    }
}

class Food2 {
    Cookable c = new Cookable() {
        public void cook() {
            System.out.println("anonymous cookable implementer");
        }
    };
}
