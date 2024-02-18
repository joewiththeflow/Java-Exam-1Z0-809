package Chapter6_Generics_and_Collections.Using_Collections;

import Chapter6_Generics_and_Collections.Using_Collections.DVDInfo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;

public class HomeEntertainmentCentre {
    public static void main(String[] args) {
        ArrayList<DVDInfo> dvdList = new ArrayList<>();
        populateList(dvdList);
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
    }

    private static void populateList(ArrayList<DVDInfo> dvdList) {
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
