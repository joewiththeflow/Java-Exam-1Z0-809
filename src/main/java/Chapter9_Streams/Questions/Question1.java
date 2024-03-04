package Chapter9_Streams.Questions;

import java.util.Arrays;

public class Question1 {
    public static void main(String[] args) {

        int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int sum = Arrays.stream(nums)
                .reduce(0, (n1, n2) -> n1 + n2);        // L1

        // Which code fragment will compile correctly and sum the numbers and store in the sum variable?

        // A. .reduce((n1, n2) -> n1 + n2);
        // B. .reduce(0, (n1, n2) -> n1 + n2);      --> CORRECT - you need an identity (e.g. 0) or an optional will be
                                                                // returned
        // C. .reduce(nums);
        // D. .reduce(0, n1 + n2);


    }
}
