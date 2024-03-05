package Chapter9_Streams.Questions;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Question11 {
    public static void main(String[] args) {

        List<Temperature> julyAvgs = new ArrayList<>();
        julyAvgs.add(new Temperature("Death Valley, CA", 107.4));
        julyAvgs.add(new Temperature("Salt Lake City, UT", 85.3));
        julyAvgs.add(new Temperature("Reno, NV", 80.5));
        julyAvgs.add(new Temperature("Bishop, CA", 80.8));
        julyAvgs.add(new Temperature("Phoenix, AZ", 106.0));
        julyAvgs.add(new Temperature("Miami, FL", 85.7));

        // what is the correct TYPE for the following fragment?

        Comparator<Temperature>
                tcompare = ((t1, t2) -> t1.getTemp().compareTo(t2.getTemp()));
        // TYPE max = julyAvgs.stream().max(tcompare);

        // A. Optional<Double>
        // B. Optional<Temperature>     --> CORRECT, max() called on Temp stream using comparator to find max Temp
        // C. OptionalDouble
        // D. Temperature
        // E. Double
        // F. double
    }
}
