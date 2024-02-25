package Chapter8_Lambda_Expressions.Own_Functional_Interface;

public class FunctionalInterfaceExample {
    public static void main(String[] args) {

        TriPredicate<String, Integer, Integer> theTest = (s, n, w) -> {
            if (s.equals("There is no spoon") && n > 2 && w < n) {
                return true;
            } else {
                return false;
            }
        };

        System.out.println("Pass the test? " + theTest.test("Follow the white rabbit", 2, 3));
        System.out.println("Pass the test? " + theTest.test("There is no spoon", 101, 3));
    }
}

interface TriPredicate<T, U, V> {
    boolean test(T t, U u, V v);
}
