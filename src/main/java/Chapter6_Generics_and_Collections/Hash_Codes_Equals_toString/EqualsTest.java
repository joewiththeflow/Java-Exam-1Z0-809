package Chapter6_Generics_and_Collections.Hash_Codes_Equals_toString;

public class EqualsTest {
    public static void main(String[] args) {
        System.out.println("x".equals(null));           // ---> just put this extra line in here to show that
                                                        // the equals method for an object should return false
                                                        // if the reference value is compared with null
        Moof one = new Moof(8);
        Moof two = new Moof(8);
        if (one.equals(two)) {
            System.out.println("one and two are equal");
        }
    }
}

class Moof {
    private int moofValue;
    Moof(int val) {
        moofValue = val;
    }

    public int getMoofValue() {
        return moofValue;
    }

    @Override
    public boolean equals(Object o) {
        if ((o instanceof Moof) && (((Moof)o).getMoofValue() == this.moofValue)) {
            return true;
        } else {
            return false;
        }
    }
}
