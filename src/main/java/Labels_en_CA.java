import java.util.ListResourceBundle;
import java.util.Locale;
import java.util.ResourceBundle;

public class Labels_en_CA extends ListResourceBundle {
    protected Object [][] getContents() {
        return new Object[][] {
                {"hello2", new StringBuilder("from Java")}
        };
    }

    public static void main(String[] args) {
        Locale locale = new Locale("en", "CA");
        ResourceBundle rb = ResourceBundle.getBundle("Labels", locale);
        System.out.println(rb.getObject("hello2"));
    }
}
