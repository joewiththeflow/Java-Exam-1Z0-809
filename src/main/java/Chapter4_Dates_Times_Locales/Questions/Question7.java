package Chapter4_Dates_Times_Locales.Questions;

import java.util.Locale;
import java.util.ResourceBundle;

public class Question7 {
//    Given 3 resource bundles:

//    Train_en_US.properties: train=subway
//    Train_en_UK.properties: train=underground
//    Train_en.properties: ride=ride

//    public static void main(String[] args) {
//        Locale.setDefault(new Locale("en", "US"));
//        ResourceBundle rb = ResourceBundle.getBundle("Train",
//        new Locale("en", "US"));
//        System.out.print(rb.getString("ride") + " " + rb.getString("train"));
//    }

//    Which of the following, when made independently, will change the output to "ride underground"? (Choose all that apply)

//    A. Add train=underground to Train_en.properties
//    B. Change line 14 to Locale.setDefault(new Locale("en", "UK"));
//    C. Change line 16 to Locale.ENGLISH);
//    D. Change line 16 to new Locale("en", "UK"));         --> CORRECT
//    E. Delete file Train_en_US.properties

//    D is correct. As is, the code finds resource bundle Train_en_US.properties, which uses Train_en.properties as a parent. Choice D finds resource bundle Train_en_UK.properties, which uses Train_en.properties as a parent.
//
//  A, B, C, E, and F are incorrect. A is incorrect because both the parent and child have the same property.
// In this scenario, the more specific one (child) gets used. B is incorrect because the default locale only gets used
// if the requested resource bundle can’t be found. C is incorrect because it finds the resource bundle Train_en.properties,
// which does not have any “train” key. E is incorrect because there is no “ride” key once we delete the parent.

}
