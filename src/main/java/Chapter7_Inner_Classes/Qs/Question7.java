package Chapter7_Inner_Classes.Qs;

public class Question7 {
    public static void main(String[] args) {
        Cathedral c = new Cathedral();
//        Sanctum s = c.new Sanctum();
//        c.Sanctum s = c.new Sanctum();
//        c.Sanctum s = Cathedral.new Sanctum();
        Cathedral.Sanctum s = c.new Sanctum();
//        Cathedral.Sanctum s = Cathedral.new Sanctum();
        s.go();
    }
}

class Cathedral {
    class Sanctum {
        void go() {
            System.out.println("spooky");
        }
    }
}

// Which, inserted independently at line 6, compiles and produces the output "Spooky"? (Choose all that apply)

// A. Sanctum s = c.new Sanctum();
// B. c.Sanctum s = c.new Sanctum();
// C. c.Sanctum s = Cathedral.new Sanctum();
// D. Cathedral.Sanctum s = c.new Sanctum();            --> CORRECT
// E. Cathedral.Sanctum s = Cathedral.new Sanctum();