package Chapter6_Generics_and_Collections.Using_Collections;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ArrayListSort {
    public static void main(String[] args) {
        // We can sort an arrayList using Collections.sort() or we can call the sort method on the arrayList itself
        List<DVDInfo> dvdList = new ArrayList<>();
        populateList(dvdList);
        System.out.println(dvdList);        // print out ArrayList
        for (DVDInfo item : dvdList){
            System.out.println(item);       // alternatively, print out each DVDInfo item
        }
        dvdList.sort((one,two) -> one.getGenre().compareTo(two.getGenre()));
        System.out.println("---Sorted by genre");
        System.out.println(dvdList);        // print out ArrayList
        for (DVDInfo item : dvdList){
            System.out.println(item);       // alternatively, print out each DVDInfo item
        }
    }

    private static void populateList(List<DVDInfo> dvdList) {    // again as it is static variable, we don't need to pass dvdList in
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
