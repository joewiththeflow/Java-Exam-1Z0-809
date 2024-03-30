package Chapter1_Declarations_AccessControl_Enums.Questions;

class Electronic implements Device { public void doIt() {}}

abstract class Phone1 extends Electronic {}
abstract class Phone2 extends Electronic {}
class Phone3 extends Electronic implements Device {
    public void doStuff() {}
}
interface Device { public void doIt(); }

public class Question5 {
//    What is the result?

//    A. Compilation succeeds                           --> CORRECT
//    B. Compilation fails with an error on line 3
//    C. Compilation fails with an error on line 5
//    D. Compilation fails with an error on line 6
//    E. Compilation fails with an error on line 7
//    F. Compilation fails with an error on line 10
}

