package Chapter4_Dates_Times_Locales.Questions;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Question4 {
    public static void main(String[] args) {
        ZonedDateTime nowzdt = ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("US/Pacific"));

//        How would you use nowzdt to compute the equivalent time in Berlin, Germany? (Choose all that apply)

//        A. ZonedDateTime berlinZdt = ZonedDateTime.from(nowzdt, ZoneId.of("Europe/Berlin"));
//        B. ZonedDateTime berlinZdt = nowzdt.withZoneSameInstant(ZoneId.of("Europe/Berlin"));                  --> CORRECT
//        C. ZonedDateTime berlinZdt = ZonedDateTime.ofInstant(nowzdt.toInstant(), ZoneId.of("Europe/Berlin")); --> CORRECT
//        D. ZonedDateTime berlinZdt = nowzdt.withZoneId("Europe/Berlin");
//        E. ZonedDateTime berlinZdt = nowzdt.now(ZoneId.of("Europe/Berlin"));
    }
}
