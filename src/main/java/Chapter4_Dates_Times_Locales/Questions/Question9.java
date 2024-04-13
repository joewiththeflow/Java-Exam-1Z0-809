package Chapter4_Dates_Times_Locales.Questions;

public class Question9 {

//    Given two files:

//    package rb;
//    public class Bundle extends java.util.ListResourceBundle {
//        protected Object[][] getContents() {
//            return new Object[][] { { "123", 456 } };
//        }


//    package rb;
//    import java.util.*;
//    public class KeyValue {
//        public static void main(String[] args) {
//          ResourceBundle rb = ResourceBundle.getBundle("rb.Bundle", Locale.getDefault());
            // INSERT CODE HERE
//        }
//    }

//    Which inserted independently will compile? (Choose all that apply)

//    A. Object obj = rb.getInteger("123");
//    B. Object obj = rb.getInteger(123);
//    C. Object obj = rb.getObject("123");          --> CORRECT
//    D. Object obj = rb.getObject(123);
//    E. Object obj = rb.getString("123");          --> CORRECT
//    F. Object obj = rb.getString(123);


//    C and E are correct. When getting a key from a resource bundle, the key must be a string. The returned result
//    must be a string or an object. While that object may happen to be an integer, the API is still getObject().
//    E will throw a ClassCastException since 456 is not a string, but it will compile.
}
