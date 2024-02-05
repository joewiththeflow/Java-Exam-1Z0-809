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
