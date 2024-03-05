package Chapter9_Streams.Questions;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

public class Question12 {
    public static void main(String[] args) {
        List<Temperature> julyAvgs = new ArrayList<>();
        julyAvgs.add(new Temperature("Death Valley, CA", 107.4));
        julyAvgs.add(new Temperature("Salt Lake City, UT", 85.3));
        julyAvgs.add(new Temperature("Reno, NV", 80.5));
        julyAvgs.add(new Temperature("Bishop, CA", 80.8));
        julyAvgs.add(new Temperature("Phoenix, AZ", 106.0));
        julyAvgs.add(new Temperature("Miami, FL", 85.7));

        // What is the correct TYPE for maxT?

        // TYPE maxT = julyAvgs.stream().mapToDouble(t -> t.getTemp()).max();

        // A. Optional<Double>
        // B. Optional<Temperature>
        // C. OptionalDouble            --> CORRECT, mapped to a DoubleStream before calling max()
        // D. Temperature
        // E. Double
        // F. double
    }
}
