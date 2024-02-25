package Chapter8_Lambda_Expressions.Functional_Interfaces;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class PredicateExamples {

    public static void main(String[] args) {
        Dog boi = new Dog("boi", 6, 30);
        Dog clover = new Dog("clover", 12, 35);

        Predicate<Dog> p = d -> d.getAge() > 9;
        System.out.println("Is Boi older than 9? " + p.test(boi));
        System.out.println("Is Clover older than 9? " + p.test(clover));


        ArrayList<Dog> dogs = new ArrayList<>();
        Dog aiko = new Dog("aiko", 10, 50);
        Dog zooey = new Dog("zooey", 8, 45);
        Dog charis = new Dog("charis", 7, 120);
        dogs.add(boi);
        dogs.add(clover);
        dogs.add(aiko);
        dogs.add(zooey);
        dogs.add(charis);

        System.out.println("---- All dogs ----");
        dogs.forEach(d -> System.out.println(d));

        System.out.println("---- Dogs younger than 9 ----");
        printDogIf(dogs, d -> d.getAge() < 9);

        System.out.println("---- Dogs 9 or older ----");
        printDogIf(dogs, d -> d.getAge() >= 9);

        Predicate<Dog> findCs = d -> d.getName().startsWith("c");
        dogs.removeIf(findCs);
        System.out.println("---- After removing dogs whose names begin with c ----");
        dogs.forEach(d -> System.out.println(d));

        // You can chain predicates together to potentially save you creating new predicates
        // e.g. if we have a predicate that tests if age is equal to 6 we can use the default negate() method
        // of the Predicate<T. interface instead of creating a new one:
        Predicate<Dog> age = d -> d.getAge() == 6;
        System.out.println("Is boi not 6? " + age.negate().test(boi));

        // or() and and() need other predicates, so to chain them you need two predicates
        Predicate<Dog> name = d -> d.getName().equals("boi");
        Predicate<Dog> nameAndAge = d -> name.and(age).test(d);
        System.out.println("---- Test name and age of boi ----");
        System.out.println("Is boi named 'boi' and age 6? " + nameAndAge.test(boi));
        boi.setAge(7);
        System.out.println("Is boi named 'boi' and age 6?" + nameAndAge.test(boi));

        // can simplify the nameAndAge predicate further:
        Predicate<Dog> nameAndAge2 = name.and(age);
        System.out.println("Is boi named 'boi' and age 6?" + nameAndAge2.test(boi));


        // isEqual can be used to test if two objects are equal but can only be used on preciates that take objects as args
        Predicate<Dog> p2 = Predicate.isEqual(zooey);
        System.out.println("Is aiko the same object as zooey? " + p2.test(aiko));
        System.out.println("Is aiko the same object as zooey? " + p2.test(zooey));


        // There are also predicates that take the primitive types. This can be better than having to convert Integer to
        // int before testing
        IntPredicate universeAnswer = i -> i == 42;
        System.out.println("Is the answer 42? " + universeAnswer.test(42));


        // BiPredicate allows you to pass in two objects for testing instead of one
        // e.g should we buy a book based on its name, price or name AND price?
        List<Book> books = Book.loadBooks();
        books.forEach(d -> System.out.println(d));
        BiPredicate<String, Double> javaBuy = (name2, price) -> name2.contains("Java");
        BiPredicate<String, Double> priceBuy = (name2, price) -> price < 55.00;
        BiPredicate<String, Double> definitelyBuy = javaBuy.and(priceBuy);
        books.forEach(book -> {
            if (definitelyBuy.test(book.getName(), book.getPrice())) {
                System.out.println("You should definitely buy " + book.getName() + "(" + book.getPrice() + ")");
            }
        });

    }

    private static void printDogIf(ArrayList<Dog> dogs, Predicate<Dog> p) {
        for (Dog d: dogs) {
            if (p.test(d)) {
                System.out.println(d);
            }
        }
    }
}

class Book {
    String name;
    double price;

    public Book(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public static List<Book> loadBooks() {
        List<Book> bookList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(new File("src/main/java/Chapter8_Lambda_Expressions/Functional_Interfaces/books.txt")))) {
            String s;
            while((s = br.readLine()) != null) {
                String[] bookDetails = s.split(", ");
                System.out.println(bookDetails[0] + "   " + bookDetails[1]);
                bookList.add(new Book(bookDetails[0], (Double.valueOf(bookDetails[1]))));
            }
        } catch (Exception e) { }

        return bookList;
    }
}

