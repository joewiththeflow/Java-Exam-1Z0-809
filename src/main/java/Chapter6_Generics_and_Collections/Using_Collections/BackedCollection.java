package Chapter6_Generics_and_Collections.Using_Collections;

import java.util.SortedMap;
import java.util.TreeMap;

public class BackedCollection {
    public static void main(String[] args) {
        TreeMap<String, String> map = new TreeMap<>();
        map.put("a", "ant");
        map.put("d", "dog");
        map.put("h", "horse");

        SortedMap<String, String> submap;
        submap = map.subMap("b", "g");              // create a backed collection

        System.out.println(map + " " + submap);     // show contents

        map.put("b", "bat");                        // add to original
        submap.put("f", "fish");                    // add to copy

        map.put("r", "raccoon");                    // add to original - out of range
        // submap.put("p", "pig");                  // add to copy - out of range

        System.out.println(map + " " + submap);     // show final contents
    }
}
