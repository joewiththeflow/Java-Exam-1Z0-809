package Chapter4_Dates_Times_Locales.Questions;

import java.time.LocalTime;

public class Question2 {

    LocalTime t1 = LocalTime.of(9, 0);
    LocalTime t2 = LocalTime.of(10, 5);
}

// Which of the following code fragment(s) will produce a new LocalTime t3 that represents the same time as t2?

// A. LocalTime t3 = t1.plus(65, ChronoUnit.MINUTES);       --> CORRECT
// B. LocalTime t3 = t1.plusMinutes(65);                    --> CORRECT
// C. LocalTime t3 = t1.plusHours(1);
// D. LocalTime t3 = t1.plusDays(1);
// E. LocalTime t3 = t1.plus(Duration.ofMinutes(65));       --> CORRECT