package Chapter4_Dates_Times_Locales.Questions;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Question10 {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.of(2017,10,27,14,22,54,0);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(" ");     //L1
        String formattedDateTime = now.format(formatter);
        System.out.println("Formatted DateTime: " + formattedDateTime);
    }

//    Which string inserted as an argument to DateTimeFormatter.ofPattern() at // L1 will produce the output?

//    Formatted DateTime: 2017-10-27 14:22:54

//    A."yyyy-MM-dd hh:mm:ss a"
//    B."yyyy-MM-dd hh:mm:ss:
//    C."yyyy-mm-dd HH:MM:ss"
//    D."yyyy-MM-dd HH:mm:ss"       --> CORRECT
//    E."yyyy-MM-dd HH:mm:ss Z"

//    A, B, C, and E are incorrect. A uses hh for the hour, which will show 02 instead 14 (that is, a 12-hour format
//    instead of a 24-hour format), and displays the AM/PM at the end, which is great if we’re using 12-hour format,
//    but that’s not what we’re looking for. B results in 12-hour format instead of 24-hour format. C switches months
//    and minutes. E requires a ZonedDateTime instead of a LocalDateTime, and using this String will throw a runtime
//    exception when we try to format now with this formatter. (OCP Objectives 7.1 and 7.2)
}
