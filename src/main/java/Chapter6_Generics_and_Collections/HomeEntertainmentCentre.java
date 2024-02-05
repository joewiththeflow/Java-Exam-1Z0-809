package Chapter6_Generics_and_Collections;

import java.io.FileReader;
import java.util.ArrayList;

public class HomeEntertainmentCentre {
    public static void main(String[] args) {
        ArrayList<DVDInfo> dvdList = new ArrayList<>();
        populateList(dvdList);
        System.out.println(dvdList);
    }

    private static void populateList(ArrayList<DVDInfo> dvdList) {
//        FileReader fr = new FileReader(file);               // create a FileReader object
//        size = fr.read(in);                                 // read whole file!
//        System.out.print("size: " + size + " ");
//        for(char c : in)
//            System.out.print(c);
//        fr.close();
    }
}
