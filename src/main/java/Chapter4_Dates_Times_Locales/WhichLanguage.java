package Chapter4_Dates_Times_Locales;

import java.util.Locale;
import java.util.ResourceBundle;

public class WhichLanguage {
    public static void main(String[] args) {
        Locale locale = new Locale("en", "CA");
        ResourceBundle rb = ResourceBundle.getBundle("Labels", locale);
        System.out.println(rb.getString("hello"));
    }
}
