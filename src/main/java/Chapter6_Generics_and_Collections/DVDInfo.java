package Chapter6_Generics_and_Collections;

public class DVDInfo {
    String title;
    String genre;
    String leadActor;
    DVDInfo (String t, String g, String a) {
        title = t; genre = g; leadActor = a;
    }

    @Override
    public String toString() {
        return "DVDInfo{" +
                "title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", leadActor='" + leadActor + '\'' +
                '}';
    }
}
