package Chapter1_Declarations_AccessControl_Enums.Questions;

public class Question6 {
    public enum Days { MON, TUE, WED };

    public static void main(String[] args) {
        for (Days d: Days.values())
            ;
        Days [] d2 = Days.values();
        System.out.println(d2[2]);
    }
}

//What is the result?

// A. TUE
// B. WED                           --> CORRECT
// C. The output is unpredictable
// D. Compilation fails due to an error on line 4
// E. Compilation fails due to an error on line 7
// F. Compilation fails due to an error on line 9
// G. Compilation fails due to an error on line 10