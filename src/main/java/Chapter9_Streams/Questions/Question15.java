package Chapter9_Streams.Questions;

import java.util.ArrayList;
import java.util.List;

public class Question15 {
    public static void main(String[] args) {
        List<Temperature> julyAvgs = new ArrayList<>();
        julyAvgs.add(new Temperature("Death Valley, CA", 107.4));
        julyAvgs.add(new Temperature("Salt Lake City, UT", 85.3));
        julyAvgs.add(new Temperature("Reno, NV", 80.5));
        julyAvgs.add(new Temperature("Bishop, CA", 80.8));
        julyAvgs.add(new Temperature("Phoenix, AZ", 106.0));
        julyAvgs.add(new Temperature("Miami, FL", 85.7));

        julyAvgs.stream()
                .mapToLong(t -> Math.round(t.getTemp()))
                .sorted()
                .distinct()
                .forEach(t -> System.out.print(t + " "));

        // What is the result?

        // A. 80.5 80.8 85.3 85.7 106.0 107.4
        // B. 81 81 85 86 106 107
        // C. 81 85 86 106 107                  --> CORRECT
        // D. 107 85 81 81 106 86
    }
}
