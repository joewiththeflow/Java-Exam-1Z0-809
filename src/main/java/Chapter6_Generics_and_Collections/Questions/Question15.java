package Chapter6_Generics_and_Collections.Questions;

import java.util.ArrayList;

public class Question15 {

}

class Business { }

class Hotel extends Business { }

class Inn extends Hotel { }

class Travel {
//    ArrayList<Hotel> go() {       --> commented as it won't compile
//        // insert code here
//    }
}

// Which statement inserted independently at line 17 will compile? (Choose all that apply)

// A. return new ArrayList<Inn>();
// B. return new ArrayList<Hotel>();        --> CORRECT
// C. return new ArrayList<Object>();
// D. return new ArrayList<Business>();

