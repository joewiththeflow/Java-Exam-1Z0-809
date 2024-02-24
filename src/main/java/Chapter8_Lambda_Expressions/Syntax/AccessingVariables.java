package Chapter8_Lambda_Expressions.Syntax;

public class AccessingVariables {
    public static void main(String[] args) {

        // You can access variables from within a lambda:
        int numCats = 3;
        DogQuerier dqWithCats = d -> {
            int numBalls = 1;           // completely new variable local to lambda

            numBalls++;                                 // can modify numBalls
            System.out.println("Number of balls: " + numBalls);      // can access numBalls
            System.out.println("Number of cats: " + numCats);      // can access numBalls
            return d.getAge() > 9;
        };

        // However you cannot use the same variable name inside a lambda if it exists in the enclosing scope
        // in which a lambda is declared:
//        int numCats2 = 3;
//        int numBalls2 = 1;              // numBalls2 is in enclosing scope
//        DogQuerier dqWithCats2 = d -> {
//            int numBalls2 = 5;           // won't compile as trying to redeclare numBalls2 variable already in scope
//
//            System.out.println("Number of balls: " + numBalls2);      // can access numBalls
//            System.out.println("Number of cats: " + numCats2);      // can access numBalls
//            return d.getAge() > 9;
//        };

        // A lambda "captures" variables from the enclosing scope so you can access these variables in the lambda
        // but those variables must be final or effectively final - you can use but you cannot change:
//        int numCats3 = 3;
//        DogQuerier dqWithCats3 = d -> {
//            int numBalls3 = 1;
//            numBalls3++;
//            numCats3++;                  // won't compile as you cannot change numCats
//            System.out.println("Number of balls: " + numBalls3);      // can access numBalls
//            System.out.println("Number of cats: " + numCats3);      // can access numBalls
//            return d.getAge() > 9;
//        };

        // So the original dqWithCats we defined above can use the value of numCats provided it isn't changed:
        System.out.println("--- use DogsPlay ---");
        DogsPlay dp = new DogsPlay(dqWithCats);
        Dog clover = new Dog("clover", 35, 12);
        System.out.println("Is clover older than 9? " + dp.doQuery(clover));
    }
}
