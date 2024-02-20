package Chapter6_Generics_and_Collections.Questions;

//import Chapter5_IO_and_NIO.Serialization.Animal2;   --> commented as won't compile

public class Question6 {
}

interface Hungry<E> { void munch(E x); }

interface Carnivore<E extends Animal2> extends Hungry<E> {}

interface Herbivore<E extends Plant> extends Hungry<E> {}

abstract class Plant { }

class Grass extends Plant { }

abstract class Animal2 { }

//class Sheep extends Animal2 implements Herbivore<Sheep> {       // --> The error is here, commented as won't compile
//    public void munch(Sheep x) { }
//}

//class Wolf extends Animal2 implements Carnivore<Sheep> {          // commented as won't compile
//    public void munch(Sheep x) { }
//}

// Which of the following changes (taken separately) would allow this code to compile? (Choose all that apply)

// A. Change the Carnivore interface to
        // interface Carnivore<E extends Plant> extends Hungry<E> { }
// B. Change the Herbivore interface to                                     --> CORRECT
        // interface Herbivore<E extends Animal2> extends Hungry<E> { }
// C. Change the Sheep class to                                             --> the generic type must be the parameter
                                                                            // type in the implemented method munch(E x)
        // class Sheep extends Animal2 implements Herbivore<Plant> {
//              public void munch(Grass x) { }
//      }
// D. Change the Sheep class to                                             // Sheep has to extend Animal2 to be used
                                                                            // as generic type in Wolf class definition
//      // class Sheep extends Plant implements Carnivore<Wolf> {
//              public void munch(Wolf x) { }
//      }
// E. Change Wolf class to                                                  --> doesn't fix where the error is
//      // class Wolf extends Animal2 implements Herbivore<Grass> {
//            public void munch(Grass x) { }
//
// F. No changes necessary
