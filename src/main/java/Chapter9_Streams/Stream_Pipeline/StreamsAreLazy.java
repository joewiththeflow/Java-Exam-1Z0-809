package Chapter9_Streams.Stream_Pipeline;

import java.util.Arrays;
import java.util.List;

public class StreamsAreLazy {
    public static void main(String[] args) {

        // The stream pipeline consists of 3 parts:

        // source - describes where the data is coming from
        // intermediate operations operate on the stream and produce another, perhaps modified stream
        // terminal operation - ends the stream and typically produces some value or output

        List<String> names = Arrays.asList("Boi", "Charis", "Zooey", "Bokeh", "Clover", "Aiko");
        names.stream()
                .filter(s -> s.startsWith("B") || s.startsWith("C"))    // filter by first letter
                .filter(s -> s.length() > 3)                            // filter by length
                .forEach(System.out::println);

        // When a data element is passed through the first filter, it is possibly discarded
        // In this case, the second filter and forEach never see it, making the subsequent stream more efficient

        // If the data element is not discarded then it is passed along to the second filter
        // In the meantime, the second data element is streamed to the first filter
        // Like an assembly line, we now have the first filter working on the second data element while the second filter
        // is still working on the first one

        // In the same way, assuming filters are passed, the first data element is passed to forEach which starts working
        // on it. In the meantime, the second data element is passed to the second filter, then the third element is
        // streamed to the first filter

        // We can get some efficiencies working with streams for two reasons:

        // 1. We can do multiple operations on data in one pass, and Java is optimised so it keeps minimal intermediate
        // state during the operations part of the pipeline.
        // 2. In some circumstances we can parallelize streams to take advantage of the underlying architecture of the
        // system and do parallel computations very easily. Not all streams can be parallelized but some can.

        // Streams are lazy and despite the name can be more efficient



    }
}
