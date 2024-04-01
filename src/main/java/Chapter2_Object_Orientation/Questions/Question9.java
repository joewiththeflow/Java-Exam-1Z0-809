package Chapter2_Object_Orientation.Questions;

public class Question9 extends Tree {
    public static void main(String[] args) {
        new Question9().go();
    }
    void go() {
        go2(new Tree(), new Question9());
        go2((Question9) new Tree(), new Question9());
    }
    void go2(Tree t1, Question9 r1) {
        Question9 r2 = (Question9) t1;      // This is where an attempt to downcast a Tree will fail at runtime
        Tree t2 = (Tree) r1;
    }
}

class Tree {}

// What is the result?

// A. An exception is thrown at runtime         --> CORRECT
// B. The code compiles and runs with no output
// C. Compilation fails with an error at line 8
// D. Compilation fails with an error at line 9
// E. Compilation fails with an error at line 12
// F. Compilation fails with an error at line 13