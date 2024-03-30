package Chapter1_Declarations_AccessControl_Enums.Enums;

enum CoffeeSize2 {
    BIG(8),
    HUGE(10),
    OVERWHELMING(16) {      // a block that defines the "body" for this OVERWHELMING constant
        public String getLidCode() {    // override the method in CoffeeSize2
            return "A";
        }
    };

    CoffeeSize2(int ounces) {
        this.ounces = ounces;
    }

    private int ounces;

    public int getOunces() {
        return ounces;
    }

    public String getLidCode() {    // default value we want to return for CoffeeSize2 constants
        return "B";
    }
}

public class ConstantSpecificClassBody {
}
