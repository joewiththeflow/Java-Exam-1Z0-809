package Chapter1_Declarations_AccessControl_Enums.Enums;

enum CoffeeSize {
    // 8, 10 and 16 are passed to the constructor
    BIG(8), HUGE(10), OVERWHELMING(16);

    CoffeeSize(int ounces) {
        this.ounces = ounces;
    }

    private int ounces;

    public int getOunces() {
        return ounces;
    }
}

public class EnumExample {
    CoffeeSize size;        // each instance of EnumExample has an enum

    public static void main(String[] args) {
        EnumExample drink1 = new EnumExample();
        drink1.size = CoffeeSize.BIG;

        EnumExample drink2 = new EnumExample();
        drink2.size = CoffeeSize.OVERWHELMING;

        System.out.println(drink1.size.getOunces());    // prints 8

        for (CoffeeSize cs : CoffeeSize.values()) {
            System.out.println(cs + " " + cs.getOunces());
        }
        // Produces:
//          8
//          BIG 8
//          HUGE 10
//          OVERWHELMING 16
    }
}
