package Chapter7_Inner_Classes.Qs;

public class Question7 {
    public static void main(String[] args) {
        Cathedral c = new Cathedral();
//        Sanctum s = c.new Sanctum();
//        c.Sanctum s = c.new Sanctum();
//        c.Sanctum s = Cathedral.new Sanctum();
        Cathedral.Sanctum s = c.new Sanctum();
//        Cathedral.Sanctum s = Cathedral.new Sanctum();
    }
}

class Cathedral {
    class Sanctum {
        void go() {
            System.out.println("spooky");
        }
    }
}
