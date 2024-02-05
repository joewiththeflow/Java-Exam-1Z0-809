package Chapter4_Dates_Times_Locales;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.*;

public class Eclipse {
    public static void main(String[] args) {
        LocalDate nowDate = LocalDate.now();
        LocalTime nowTime = LocalTime.now();
        LocalDateTime nowDateTime = LocalDateTime.of(nowDate, nowTime);
        System.out.println("It's currently " + nowDateTime + " where I am");

        LocalDateTime nowDateTime2 = LocalDateTime.now();
        System.out.println("It's currently " + nowDateTime2 + " where I am");

        // Specific date
        LocalDate eclipseDate1 = LocalDate.of(2017, 8, 21);
        LocalDate eclipseDate2 = LocalDate.parse("2017-08-21");
        System.out.println("Eclipse date: " + eclipseDate1 + ", " + eclipseDate2);

        // Eclipse begins
        LocalTime begins = LocalTime.of(9, 6, 43);  // 9:06:43
        // Eclipse totality
        LocalTime totality = LocalTime.parse("10:19:36");   // 10:19:36
        System.out.println("Eclipse begins at " + begins + " and totality is at " + totality);

        String eclipseDateTime = "2017-08-21 10:19";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime eclipseDay = LocalDateTime.parse(eclipseDateTime, formatter);
        System.out.println("Eclipse day: " + eclipseDay);
        System.out.println("Eclipse day, formatted: " + eclipseDay.format(DateTimeFormatter.ofPattern("dd, MM, yy hh, mm")));

        System.out.println("Mom time: " + eclipseDay.plusHours(2));
        System.out.println("Going home: " + eclipseDay.plusDays(3));

        System.out.println("What day of the week is the eclipse " + eclipseDay.getDayOfWeek());

        ZonedDateTime zTotalityDateTime = ZonedDateTime.of(eclipseDay, ZoneId.of("US/Pacific"));
        System.out.println("Date and time totality begins with time zone: " + zTotalityDateTime);

        // List Zone IDs
        Set<String> zoneIds = ZoneId.getAvailableZoneIds();
        List<String> zoneList = new ArrayList<>(zoneIds);
        Collections.sort(zoneList);
        for (String zoneId : zoneList) {
            if (zoneId.contains("US")) {
                System.out.println(zoneId);
            }
        }

        ZoneId pacific = ZoneId.of("US/Pacific");
        // pacific.getRules() returns a ZoneRules object that has all the rules about time zones, including daylight savings and standard time.
        System.out.println("Is Daylight Savings in effect at the time of totality: " + pacific.getRules().isDaylightSavings(zTotalityDateTime.toInstant()));

        ZonedDateTime followingThursdayDateTime = zTotalityDateTime.with(TemporalAdjusters.next(DayOfWeek.THURSDAY));
        System.out.println("Thursday following the totality: " + followingThursdayDateTime);

        // Totality begins in Austin, TX in 2024 at 1.35pm and 56 seconds;
        // Specify year, month dayOfMonth, hour, minute, second, nano, zone
        ZonedDateTime totalityAustin = ZonedDateTime.of(2024, 4,8, 13, 35, 56, 0, ZoneId.of("US/Central"));
        System.out.println("Next total eclipse in the US, date/time in Austin, TX: " + totalityAustin);

        // Reminder for month before:
        Period period = Period.ofMonths(1);
        System.out.println("Period is " + period);
        ZonedDateTime reminder = totalityAustin.minus(period);
        System.out.println("DateTime of 1 month reminder: " + reminder);

        System.out.println("Local DateTime (Austin, TX) of reminder: " + reminder.toLocalDateTime());
        System.out.println("ZonedDateTime (Madras, OR) of reminder " + reminder.withZoneSameInstant(ZoneId.of("US/Pacific")));

        // Eclipse begins in Austin, TX
        LocalTime begins2 = LocalTime.of(12, 17, 32);
        // totality in Austin, TX
        LocalTime totality2 = LocalTime.of(13, 35, 56);
        System.out.println("Eclipse begins at " + begins2 + " and totality is at " + totality2);

        // How many minutes between when the eclipse begins and totality?
        long betweenMins = ChronoUnit.MINUTES.between(begins2, totality2);
        System.out.println("Minutes between begin and totality: " + betweenMins);

        Duration betweenDuration = Duration.ofMinutes(betweenMins);
        System.out.println("Duration: " + betweenDuration);

        LocalTime totalityBegins = begins2.plus(betweenDuration);
        System.out.println("Totality begins, computed: " + totalityBegins);

        ZonedDateTime totalityAustin2 = ZonedDateTime.of(2024, 4, 8, 13, 35, 56, 0, ZoneId.of("US/Central"));
        Instant totalityInstant = totalityAustin2.toInstant();
        System.out.println("Austin's eclipse instant is: " + totalityInstant);

        Instant nowInstant = Instant.now();
        Instant totalityInstant2 = totalityAustin2.toInstant();
        long minsBetween2 = ChronoUnit.MINUTES.between(nowInstant, totalityInstant2);
        Duration durationBetweenInstants = Duration.ofMinutes(minsBetween2);
        System.out.println("Minutes between " + minsBetween2 + ", is duration " + durationBetweenInstants);

        Instant now = Instant.now();
        System.out.println("Seconds since epoch: " + now.getEpochSecond());

        // Another reminder 3 days before
        System.out.println("DateTime of 3 day reminder: " + totalityAustin2.minus(Period.ofDays(3)));
        // What day of the week is that?
        System.out.println("Day of week for 3 day reminder: " + totalityAustin2.minus(Period.ofDays(3)).getDayOfWeek());

        ZonedDateTime localParis = totalityAustin2.withZoneSameInstant(ZoneId.of("Europe/Paris"));
        System.out.println("Eclipse happens at " + localParis + " Paris time");
        System.out.println("Phone sister at 2 hours after totality: " + totalityAustin2.plusHours(2) + ", " + localParis.plusHours(2) + " Paris time");

        // Compare two zonedDateTimes (must be same type!)
        System.out.println("Is the 2024 eclipse still in the future? " + ZonedDateTime.now().isBefore(totalityAustin2));

        System.out.println("Is 2024 a leap year? " + totalityAustin2.toLocalDate().isLeapYear());
        System.out.println("Is 2024 a leap year? " + Year.of(2024).isLeap());

        System.out.println("Totality date/time written for sister in Europe: " + totalityAustin2.format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm")));
        System.out.println("Totality date/time in UK Locale: " + totalityAustin2.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).withLocale(Locale.UK)));

        Locale myLocale = Locale.getDefault();
        System.out.println("My Locale: " + myLocale);
        LocalDateTime aDateTime = LocalDateTime.of(2024, 4, 8, 13, 35, 56);
        System.out.println("The date and tme: " + aDateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));
        ZonedDateTime zDateTime = ZonedDateTime.of(aDateTime, ZoneId.of("US/Pacific"));

        Locale locIT = new Locale("it", "IT");
        Locale locPT = new Locale("pt");
        Locale locBR = new Locale("pt", "BR");
        Locale locIN = new Locale("hi", "IN");
        Locale locJA = new Locale("ja");
        Locale locDK = new Locale("da", "DK");

        System.out.println("Italy (long) " + zDateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG).withLocale(Locale.ITALY)));
        System.out.println("Italy (Short) " + aDateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).withLocale(locIT)));

        System.out.println("Japan (Long) " + zDateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG).withLocale(Locale.JAPAN)));
        System.out.println("Portugal (Long) " + zDateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG).withLocale(locPT)));
        System.out.println("India (long) " + zDateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG).withLocale(locIN)));
        System.out.println("Denmark (Medium) " + zDateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).withLocale(locDK)));


        System.out.println("Denmark, country: " + locDK.getDisplayCountry());
        System.out.println("Denmark, country, local: " + locDK.getDisplayCountry(locDK));
        System.out.println("Denmark, language: " + locDK.getDisplayLanguage());
        System.out.println("Denmark, language, local: " + locDK.getDisplayLanguage(locDK));

        System.out.println("Brazil, country: " + locBR.getDisplayCountry());
        System.out.println("Brazil, country, local: " + locBR.getDisplayCountry(locBR));
        System.out.println("Brazil, language: " + locBR.getDisplayLanguage());
        System.out.println("Brazil, language, local: " + locBR.getDisplayLanguage(locBR));

        System.out.println("Italy, Danish language is: " + locDK.getDisplayLanguage(locIT));

    }
}
