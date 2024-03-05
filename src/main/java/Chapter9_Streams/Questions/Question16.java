package Chapter9_Streams.Questions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Question16 {
    public static void main(String[] args) {
        List<Temperature> julyAvgs = new ArrayList<>();
        julyAvgs.add(new Temperature("Death Valley, CA", 107.4));
        julyAvgs.add(new Temperature("Salt Lake City, UT", 85.3));
        julyAvgs.add(new Temperature("Reno, NV", 80.5));
        julyAvgs.add(new Temperature("Bishop, CA", 80.8));
        julyAvgs.add(new Temperature("Phoenix, AZ", 106.0));
        julyAvgs.add(new Temperature("Miami, FL", 85.7));

        Map<Boolean, List<String>> temp100 =
                julyAvgs.stream().collect(
                        Collectors.partitioningBy(t -> t.getTemp() >= 100,
                                Collectors.mapping(t -> t.getLocation(),
                                        Collectors.toList())));
        System.out.println(temp100);

        // What is the result?

        // A. Salt Lake City, UT, Reno, NV, Bishop, CA, Miami, FL, Death Valley, CA, Phoenix, AZ
        // B. {false=[Salt Lake City, UT, Reno, NV, Bishop, CA, Miami, FL], true=[Death Valley, CA, Phoenix, AZ]}  --> CORRECT
        // C. 106 107
        // D. Death Valley, CA, Phoenix, AZ
    }
}
