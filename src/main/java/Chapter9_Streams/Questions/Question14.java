package Chapter9_Streams.Questions;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Question14 {
    public static void main(String[] args) {
        List<Temperature> julyAvgs = new ArrayList<>();
        julyAvgs.add(new Temperature("Death Valley, CA", 107.4));
        julyAvgs.add(new Temperature("Salt Lake City, UT", 85.3));
        julyAvgs.add(new Temperature("Reno, NV", 80.5));
        julyAvgs.add(new Temperature("Bishop, CA", 80.8));
        julyAvgs.add(new Temperature("Phoenix, AZ", 106.0));
        julyAvgs.add(new Temperature("Miami, FL", 85.7));

        // Which code fragment(s) inserted independently at // L1 cause the code to print the Temperatures from
        // high to low?

        Comparator<Temperature> tCompare =
                ((t1, t2) -> t1.getTemp().compareTo(t2.getTemp()));
        // List<Temperature> sortedTemps =
                // julyAvgs.stream()
                        // L1
        // sortedTemps.forEach(System.out::println);

        // A. .sorted().reversed().collect(Collectors.toList());
        // B. .sorted(Comparator.comparing(t -> t.getTemp()).collect(Collectors.toList());
        // C. .sorted(tCompare).collect(Collectors.toList());
        // D. .sorted(tCompare.reversed()).collect(Collectors.toList());        --> CORRECT

    }
}
