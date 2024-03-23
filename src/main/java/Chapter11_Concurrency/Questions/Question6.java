package Chapter11_Concurrency.Questions;

public class Question6 {
//    Given
//
//    ConcurrentMap<String, Integer> ages = new ConcurrentHashMap<>();
//    ages.put("John", 23);

//    Which method(s) would delete John from the map only if his value was still equal to 23?

//    A. ages.delete("John", 23);
//    B. ages.deleteIfEquals("John", 23);
//    C. ages.remove("John", 23);           --> CORRECT
//    D. ages.removeIfEquals("John", 23);



//     C is correct; it uses the correct syntax.
//
// The methods for answers A, B, and D do not exist in a ConcurrentHashMap. A traditional Map contains a
// single-argument remove method that removes an element based on its key. The ConcurrentMap interface
// (which ConcurrentHashMap implements) added the two-argument remove method, which takes a key and a value.
// An element will only be removed from the Map if its value matches the second argument. A boolean is returned to
// indicate if the element was removed. (OCP Objective 10.4)
}
