package Chapter6_Generics_and_Collections.Hash_Codes_Equals_toString;

public class ToStringExample {
    public static void main(String[] args) {
        Bob f = new Bob("GoBobGo", 19);
        System.out.println(f);
    }
}

class Bob {
    int shoeSize;
    String nickName;
    Bob(String nickName, int shoeSize) {
        this.shoeSize = shoeSize;
        this.nickName = nickName;
    }
    public String toString() {
        return ("I am a Bob, but you can call me " + nickName + ". My shoe size is " + shoeSize);
    }
}
