package Chapter9_Streams.Questions;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Question13 {
    public static void main(String[] args) {
        List<Temperature> julyAvgs = new ArrayList<>();
        julyAvgs.add(new Temperature("Death Valley, CA", 107.4));
        julyAvgs.add(new Temperature("Salt Lake City, UT", 85.3));
        julyAvgs.add(new Temperature("Reno, NV", 80.5));
        julyAvgs.add(new Temperature("Bishop, CA", 80.8));
        julyAvgs.add(new Temperature("Phoenix, AZ", 106.0));
        julyAvgs.add(new Temperature("Miami, FL", 85.7));

        Comparator<Temperature> tCompare =
                ((t1, t2) -> t1.getTemp().compareTo(t2.getTemp()));
        Optional<Temperature> min = julyAvgs.stream().min(tCompare);
        min.ifPresent(m -> System.out.println("Min: " + m));
        Optional<Temperature> coolerSpot =
                julyAvgs.stream().filter(t -> t.getTemp() < 100.0).findAny();
        if(coolerSpot.isPresent()) {
            System.out.println("A cooler spot for July: " + coolerSpot.get());
        } else {
            System.out.println("No place cool in July");
        }

        // Will the minimum temprature min be the same as coolerSpot

        // A. Yes
        // B. No
        // C. Maybe         --> CORRECT
    }
}
