package Chapter6_Generics_and_Collections.Using_Collections;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {
    public static void main(String[] args) {
        List<String> test = new ArrayList<String>();
        String s = "hi";
        test.add("string");
        test.add(s);
        test.add(s+s);
        System.out.println(test.size());
        System.out.println(test.contains(42));
        System.out.println(test.contains("hihi"));
        test.remove("hi");
        System.out.println(test.size());
    }
}
