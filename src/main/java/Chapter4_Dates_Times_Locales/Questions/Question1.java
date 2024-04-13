package Chapter4_Dates_Times_Locales.Questions;

import java.time.ZonedDateTime;

public class Question1 {
    public static void main(String[] args) {
        // Given the code fragment

//        ZonedDateTime zd = ZonedDateTime.parse("2020-05-04T08:05:00");
//        System.out.println(zd.getMonth() + " " + zd.getDayOfMonth());
    }

//    A. MAY 4
//    B. APRIL 5
//    C. MAY 4 2020
//    D. APRIL 5 2020
//    E. Compilation fails
//    F. Runtime Exception      --> CORRECT, no zone id in string

}

// 1. E ---- should be F
// 2. A, B, E
// 3. D ---- should be E
// 4. B ---- should also be C
// 5. D ---- should be C
// 6. A, C, D, E
// 7. D
// 8.
// 9. C ---- should also be E
// 10. D
// 11. E ---- should be C
// 12. E ---- should be A
