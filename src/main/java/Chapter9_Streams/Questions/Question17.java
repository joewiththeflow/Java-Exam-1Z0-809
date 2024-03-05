package Chapter9_Streams.Questions;

import java.util.ArrayList;
import java.util.List;

public class Question17 {
    public static void main(String[] args) {
        List<Temperature> julyAvgs = new ArrayList<>();
        julyAvgs.add(new Temperature("Death Valley, CA", 107.4));
        julyAvgs.add(new Temperature("Salt Lake City, UT", 85.3));
        julyAvgs.add(new Temperature("Reno, NV", 80.5));
        julyAvgs.add(new Temperature("Bishop, CA", 80.8));
        julyAvgs.add(new Temperature("Phoenix, AZ", 106.0));
        julyAvgs.add(new Temperature("Miami, FL", 85.7));

        // Which of the following fragments will print Temperature objects sorted by location?

        // A.
//                julyAvgs.stream()
//                .map(t -> t.getLocation())
//                .sorted()
//                .forEach(System.out::println);
        // B.
//                julyAvgs.stream()
//                .sorted(Temperature::getLocation)
//                .forEach(System.out::println);
        // C.                                                                       --> CORRECT
//        julyAvgs.stream()
//                .sorted((t1, t2) -> t1.getLocation().compareTo(t2.getLocation()))
//                .forEach(System.out::println);
        // D.
//                julyAvgs.stream()
//                .map(t -> t.getLocation())
//                .sorted((l1, l2) -> l1.compareTo(l2))
//                .forEach(System.out::println);
    }
}
