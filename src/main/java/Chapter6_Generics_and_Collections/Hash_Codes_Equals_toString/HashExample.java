package Chapter6_Generics_and_Collections.Hash_Codes_Equals_toString;

public class HashExample {
    public int x;
    HashExample(int xVal) { x = xVal; }

    public boolean equals(Object o) {
        if (o instanceof HashExample && ((HashExample) o).x == this.x) {
            return true;
        } else {
            return false;
        }
    }

    public int hashCode() { return (x * 17); }
}
