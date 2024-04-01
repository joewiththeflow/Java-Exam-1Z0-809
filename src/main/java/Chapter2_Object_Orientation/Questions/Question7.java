package Chapter2_Object_Orientation.Questions;

public class Question7 {
    Question7() { main("hi"); }

    public static void main(String[] args) {
        System.out.print("2 ");
    }

    public static void main(String args) {
        System.out.print("3 " + args);
    }
}

// What is the result? (Choose all that apply)

// A. 2 will be included in the output      --> CORRECT
// B. 3 will be included in the output
// C. hi will be included in the output
// D. Compilation fails
// E. An exception is thrown at runtime