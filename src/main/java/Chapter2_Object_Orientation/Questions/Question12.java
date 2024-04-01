package Chapter2_Object_Orientation.Questions;

class Building {
    Building() {
        System.out.print("b ");
    }
    Building(String name) {
        this();
        System.out.print("bn" + name);
    }
}
public class Question12 extends Building {
    Question12() {
        System.out.print("h ");
    }
    Question12(String name) {
        this();
        System.out.print("hn " + name);
    }

    public static void main(String[] args) {
        new Question12("x ");
    }
}

// What is the result?

// A. h hn x
// B. hn x h
// C. b h hn x          --> CORRECT
// D. b hn x h
// E. bn x h hn x
// F. b bn x h hn x
// G. bn x b h hn x
// H. Compilation fails