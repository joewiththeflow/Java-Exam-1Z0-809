package Chapter11_Concurrency.Parallel_Streams;

import java.time.Instant;
import java.util.stream.IntStream;

public class StatefulStreamsExamples {
    public static void main(String[] args) {
        final int SIZE = 100_000_000;
        final int LIMIT = 5;
        long sum = 0, startTime, endTime, duration;

        IntStream stream = IntStream.range(0, SIZE);
        System.out.println(stream);
        startTime = Instant.now().toEpochMilli();
        sum = stream
//                .parallel()
                .limit(LIMIT)
                .sum();
        endTime = Instant.now().toEpochMilli();
        duration = endTime - startTime;
        System.out.println("Items summed in " + duration + " milliseconds; sum is: " + sum);

        // using parallel will actually take longer (using limit means there has to be overhead in tracking if we've
        // reached the limit)


    }
}
