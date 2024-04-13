package Chapter4_Dates_Times_Locales.Questions;

import java.time.DayOfWeek;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class Question8 {

//    This is a drag and drop so we will just write out the answer

//    Let’s say you want to print the day of the week and the date of Halloween (October 31) 2018, at 5 PM in German,
//    using the LONG style. Complete the code below using the following fragments. Note: You can use each fragment either
//    zero or more times, and you might not need to fill all of the slots. You probably won’t encounter a fill-in-the-blank
//    question on the exam, but just in case, we put a few in the book, like this one.

    public static void main(String[] args) {
        ZonedDateTime d = ZonedDateTime.of(2018, 10, 31, 17, 0, 0, 0,
                ZoneId.of("Europe/Berlin"));
        Locale locDE = new Locale("de");
        DayOfWeek day = d.getDayOfWeek();
        String df = d.format(DateTimeFormatter.
                ofLocalizedDate(FormatStyle.LONG).withLocale(locDE));
        System.out.println(day + " " + df);
    }
}
