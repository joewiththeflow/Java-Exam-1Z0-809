package Chapter4_Dates_Times_Locales;

import java.util.Locale;

public class Default {
    public static void main(String[] args) {
        Locale initial = Locale.getDefault();
        System.out.println(initial);

        Locale.setDefault(Locale.GERMANY);
        System.out.println(Locale.getDefault());

        Locale.setDefault(initial);
        System.out.println(Locale.getDefault());
    }
}
