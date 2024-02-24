package Chapter8_Lambda_Expressions.Syntax;

public class Dog {
    String name;
    int weight;
    int age;

    public Dog(String name, int weight, int age) {
        this.name = name;
        this.weight = weight;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {
        Dog d1 = new Dog("boi", 30, 6);
        DogQuerier dq = new DogQuerier() {      // Anonymous inner class implementing interface
            @Override
            public boolean test(Dog d) {
                return d.getAge() > 9;
            }
        };

        DogQuerier dq2 = (anyParameterName) -> anyParameterName.getAge() > 9;   // Use a lambda instead
        DogQuerier dq3 = d -> d.getAge() > 9;   // You don't need parenthesis if using only 1 parameter
        DogQuerier dq4 = (Dog d) -> d.getAge() > 9;   // You need parenthesis if you supply the parameter Type

        // As you only have one expression in the lambda, you don't need the return statement.
        // In fact, if you try to include it then it won't compile:
//        DogQuerier dq5 = d -> return d.getAge() > 9;
        // Instead, if you want to include the return, you have to write the lambda with braces:
        DogQuerier dq6 = d -> { return d.getAge() > 9; };

        // A lambda with multiple statements needs braces
        DogQuerier dq7 = d -> {
            System.out.println("Testing " + d.getName());
            return d.getAge() > 9;
        };

        System.out.println("Is boi older than 9? " + dq.test(d1));
        System.out.println("Is boi older than 9? " + dq2.test(d1));
        System.out.println("Is boi older than 9? " + dq3.test(d1));
        System.out.println("Is boi older than 9? " + dq4.test(d1));
//        System.out.println("Is boi older than 9? " + dq5.test(d1));
        System.out.println("Is boi older than 9? " + dq6.test(d1));
        System.out.println("Is boi older than 9? " + dq7.test(d1));


        DogsPlay dp = new DogsPlay(dq); // You could pass a DogQuerier object
        DogsPlay dp2 = new DogsPlay(d -> d.getAge() > 9 ); // You can pass the lambda instead of creating a DogQuerier first

        System.out.println("Is boi older than 9? " + dp.doQuery(d1));
        System.out.println("Is boi older than 9? " + dp2.doQuery(d1));
    }
}

class DogsPlay {
    DogQuerier dogQuerier;

    public DogsPlay(DogQuerier dogQuerier) {
        this.dogQuerier = dogQuerier;
    }
    public boolean doQuery(Dog d) {
        return dogQuerier.test(d);
    }
}
