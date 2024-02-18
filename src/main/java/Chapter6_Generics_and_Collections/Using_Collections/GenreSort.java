package Chapter6_Generics_and_Collections.Using_Collections;

import java.util.Comparator;

public class GenreSort implements Comparator<DVDInfo> {
    @Override
    public int compare(DVDInfo o1, DVDInfo o2) {    // the in returned is the same meaning as compareTo() returned int
        return o1.getGenre().compareTo(o2.getGenre());      // Therefore, we can take advantage of String's compareTo()
    }
}
