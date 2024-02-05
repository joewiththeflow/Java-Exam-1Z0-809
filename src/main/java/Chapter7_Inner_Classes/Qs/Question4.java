package Chapter7_Inner_Classes.Qs;

public class Question4 {
    public static void main (String[] args) {
        Object o = new Object() {
            public boolean equals(Object obj) {
                return true;
            }
//        }    // Will fail because there needs to be a ";" at the end here
        };
        System.out.println(o.equals("Fred"));
    }
}
