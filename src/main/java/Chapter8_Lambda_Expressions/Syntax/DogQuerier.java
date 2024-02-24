package Chapter8_Lambda_Expressions.Syntax;

@FunctionalInterface                    // This annotation is not required but allows compiler to war if you add another method
public interface DogQuerier {
    public boolean test(Dog d);
}
