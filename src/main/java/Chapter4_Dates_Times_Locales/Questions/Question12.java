package Chapter4_Dates_Times_Locales.Questions;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Question12 {

//    If it is 19:12:53 on October 27, 2017 in the US/Pacific Zone (which is GMT-8:00, summer time), then what does
//    the following code fragment produce? (Choose all that apply)

    public static void main(String[] args) {
        ZoneId zid = ZoneId.of("US/Eastern");   // GMT-5:00
        Instant i = Instant.now();
        ZonedDateTime zdt = i.atZone(zid);
        System.out.println(zdt.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM)));
    }
}

// A. 10:12:53 PM       --> CORRECT
// B. 20:12:53
// C. 19:12:53
// D. 7:12:53 PM
// E. 2017-10-27 10:12:53 PM


// A is correct. We first get the zoneId for “US/Eastern" time, which is GMT-5:00, and the locale to US. We then create
// an Instant for “now,” which is 19:12:53 on October 27, 2017 (7:12:53 PM PDT, which is 10:12:53 PM EDT). We then create
// a ZonedDateTime from the Instant, using the zoneId for "US/Eastern" and format it using DateTimeFormatter.ofLocalizedTime(),
// which turns the ZonedDateTime into a LocalTime (dropping the date and zone information) and display it in the MEDIUM format
// style for the US locale, resulting in 10:12:53 PM. Format styles depend on local configuration, but we know this answer is
// correct because B, C, and D show the incorrect times, and E shows the date.
//
// B, C, D, and E are incorrect. B, C, and D show the incorrect times, and E shows the date, which we dropped when
// we formatted zdt to a localized time. (OCP Objectives 7.2)