package Chapter6_Generics_and_Collections.Using_Collections;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;

public class HomeEntertainmentCentre2 {
    static ArrayList<DVDInfo> dvdList = new ArrayList<>();      // needs to be static so that static methods can access
                                                                // We could declare this inside main but we can put here
                                                                // so that we can call go() without passing in dvdList
    public static void main(String[] args) {

        go();
    }

    private static void go() {
        populateList();
        System.out.println(dvdList);        // print out ArrayList
        for (DVDInfo item : dvdList){
            System.out.println(item);       // alternatively, print out each DVDInfo item
        }
        // Sort the ArrayList
        Collections.sort(dvdList);

        System.out.println(dvdList);        // print out ArrayList
        for (DVDInfo item : dvdList){
            System.out.println(item);       // alternatively, print out each DVDInfo item
        }

        // Sort Array List by Genre
        GenreSort gs = new GenreSort();     // class implements Comparator
        Collections.sort(dvdList, gs);

        System.out.println(dvdList);        // print out ArrayList
        for (DVDInfo item : dvdList){
            System.out.println(item);       // alternatively, print out each DVDInfo item
        }
    }

    private static void populateList() {    // again as it is static variable, we don't need to pass dvdList in
        // Read file using try with resources to avoid need to close
        try (BufferedReader br = new BufferedReader(
                new FileReader("src/main/java/Chapter6_Generics_and_Collections/Using_Collections/dvdinfo.txt"))) {
            String s;
            while ((s = br.readLine()) != null) {
                String[] splitString = s.split("/");
                dvdList.add(new DVDInfo(splitString[0], splitString[1], splitString[2]));
            }
        } catch (Exception x) { }
    }
}
