package Chapter4_Dates_Times_Locales.Questions;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Question5 {
    public static void main(String[] args) {

//        The next solar eclipse visible in South America is on July 2 2019 at 16:55 UTC. Which code fragment will
//        correctly compute and display the time in San Juan, Argentina, for this solar eclipse?

//        A.
//        ZonedDateTime totalityUTC = ZonedDateTime.of(
//                LocalDateTime.of(2019, 7, 2, 16, 55));
//        ZonedDateTime totalitySanJuan =
//                totalityUTC.withZoneSameInstant(ZoneId.of("America/Argentina/San_Juan"));
//        System.out.println(totalitySanJuan);

//        B.
//        ZonedDateTime totalityUTC = ZonedDateTime.of(
//                LocalDateTime.of(2019, 7, 2, 4, 55, "PM" ), ZoneId.of("Z"));
//        ZonedDateTime totalitySanJuan =
//                totalityUTC.withZoneSameInstant(ZoneId.of("America/Argentina/San_Juan"));
//        System.out.println(totalitySanJuan);

//        C.                                                                                --> CORRECT
//        ZonedDateTime totalityUTC = ZonedDateTime.of(
//                LocalDateTime.of(2019, 7, 2, 16, 55), ZoneId.of("Z"));
//        ZonedDateTime totalitySanJuan =
//                totalityUTC.withZoneSameInstant(ZoneId.of("America/Argentina/San_Juan"));
//        System.out.println(totalitySanJuan);

//        D
//        ZonedDateTime totalityUTC = ZonedDateTime.of(
//                LocalDateTime.of(2019, 7, 2, 16, 55),
//                ZoneId.of("America/Argentina/San_Juan"));
//        ZonedDateTime totalitySanJuan =
//                totalityUTC.withZoneSameInstant(ZoneId.of("America/Argentina/San_Juan"));
//        System.out.println(totalitySanJuan);

//        E.
//        ZonedDateTime totalityUTC = ZonedDateTime.of(
//                LocalDateTime.of(2019, 7, 2, 16, 55), ZoneId.of("Z "));
//        LocalDateTime totalitySanJuan =
//                totalityUTC.withZoneSameInstant(ZoneId.of("America/Argentina/San_Juan"));
//        System.out.println(totalitySanJuan);


//         C is correct. We first create a ZonedDateTime for the UTC time with zone “Z” (corresponding to GMT zone) and
//         then create the equivalent ZonedDateTime for the San Juan, Argentina, zone.
//
//         A, B, D, and E are incorrect. A is missing the time zone on the UTC time. B includes incorrect arguments to
//          the LocalDateTime.of() method. D has the incorrect time zone on the UTC time. E has the incorrect type for
//          totalitySanJuan. (OCP Objective 7.2)
    }
}
