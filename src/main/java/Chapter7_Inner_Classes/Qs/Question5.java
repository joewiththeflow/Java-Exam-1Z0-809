package Chapter7_Inner_Classes.Qs;

public class Question5 {
    public static void main(String[] args) {
        class Horse {
            public String name;
            public Horse(String s) {
                name = s;
            }
        }
        Object obj = new Horse("Zippo");
//        System.out.println(obj.name);       // name is not a property of Object - the reference is Object, not Horse
    }
}

// What is the result?

// A. An exception occurs at runtime at line 12
// B. Zippo
// C. Compilation fails because of an error on line 5
// D. Compilation fails because of an error on line 11
// E. Compilation fails because of an error on line 12      --> CORRECT, Object has no parameter called name