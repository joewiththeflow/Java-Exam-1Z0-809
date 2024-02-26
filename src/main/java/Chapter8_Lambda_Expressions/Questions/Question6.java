package Chapter8_Lambda_Expressions.Questions;

import java.util.function.Supplier;

public class Question6 {
    public static void main(String[] args) {

//        Supplier<Human> human = () -> new Human(34, "Joe");
//        Human joe = human.XXXX;

//        Which fragment inserted at XXXX will cause a new Human object to be stored in the variable joe?

//        A. push()
//        B. get()      --> CORRECT
//        C. apply()
//        D. test()
//        E. accept()

    }
}

class Human {
    public Integer age;
    public String name;

    public Human(Integer age, String name) {
        this.age = age;
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }
}
