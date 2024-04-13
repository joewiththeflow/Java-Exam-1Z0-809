package Chapter4_Dates_Times_Locales.Questions;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class Question11 {
    public static void main(String[] args) {
        LocalDate d1 = LocalDate.of(2017, Month.NOVEMBER, 28);
        System.out.print(d1 + ", ");
        LocalDate d2 = d1.with(TemporalAdjusters.lastDayOfYear());
        System.out.print(d2 + ", ");
        LocalDate d3 = d1.plusDays(3).with(TemporalAdjusters.firstDayOfNextMonth());
        System.out.print(d3 + ", ");
        LocalDate d4 = d1.minusMonths(11).with(TemporalAdjusters.firstDayOfNextYear());
        System.out.print(d4 + ", ");
        LocalDate d5 = LocalDate.ofEpochDay(d1.plusDays(27).toEpochDay());
        System.out.print(d5 + ", ");
        LocalDate d6 = LocalDate.of(2017, Month.NOVEMBER, 28);
        System.out.print(d6);

    }
// A. 2017-11-28, 2017-12-31, 2017-12-01, 2017-01-01, 2017-12-25, 2017-11-23        --> CORRECT
//
// B. 2017-11-28T00:00, 2017-12-31T00:00, 2017-12-01T00:00, 2017-01-01T00:00, 2017-12-25T00:00, 2017-11-23T00:00
//
// C. 2017-11-28, 2017-12-31, 2018-01-01, 2017-01-01, 2017-12-25, 2017-11-23
//
// D. 2017-11-28T00:00, 2017-12-31T00:00, 2018-01-01T00:00, 2017-01-01T00:00, 2017-12-25T00:00, 2017-11-23T00:00
//
// E. 2017-11-28, 2017-12-31, 2018-01-01, 2018-01-01, 2017-12-25, 2017-11-23

//    A, B, D, and E are incorrect. B and D show the time, and we are displaying LocalDate values that have no time
//    associated with them. A has the incorrect value for d3, and E has the wrong value for d4. (OCP Objectives 7.1 and 7.3)
}
