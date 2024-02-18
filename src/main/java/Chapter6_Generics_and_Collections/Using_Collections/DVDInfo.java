package Chapter6_Generics_and_Collections.Using_Collections;

public class DVDInfo implements Comparable<DVDInfo> {       // needed for sorting
    private String title;
    private String genre;
    private String leadActor;
    DVDInfo (String t, String g, String a) {
        title = t; genre = g; leadActor = a;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getLeadActor() {
        return leadActor;
    }

    public void setLeadActor(String leadActor) {
        this.leadActor = leadActor;
    }

    @Override
    public String toString() {
        return "DVDInfo{" +
                "title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", leadActor='" + leadActor + '\'' +
                '}';
    }

    @Override
    public int compareTo(DVDInfo o) {           // needed for sorting
        return title.compareTo(o.getTitle());   // use String's compareTo method as it already implements Comparable
    }
}
