package Chapter6_Generics_and_Collections.Using_Collections;


import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;

// One of the important points here is that Array.sort CAN sort using a Comparator
// HOWEVER, if the array is of a primitive type, e.g. int, then you CAN'T use a Comparator
    // The Arrays.sort method first parameter is looking for an object type T, not a primitive type, if using the
    // sort method which takes a Comparator parameter
public class ArraysSort {
    public static void main(String[] args) {
        DVDInfo[] dvdList = new DVDInfo[7];
        populateList(dvdList);
        for (DVDInfo dvd : dvdList) {       // need to loop through and print as printing an array just prints the array object ref
            System.out.println(dvd);
        }
        Arrays.sort(dvdList);       // Remember DVDInfo has implemented Comparable
        System.out.println("DVDs sorted by title:");
        for (DVDInfo dvd : dvdList) {
            System.out.println(dvd);
        }
        Arrays.sort(dvdList, (one, two) -> one.getGenre().compareTo(two.getGenre()));
        System.out.println("DVDs sorted by genre:");
        for (DVDInfo dvd : dvdList) {
            System.out.println(dvd);
        }

        // Test primitive array
        int[] numbers = {1,3,5,7,9,2,4,6,8};
        System.out.println("Original ints: ");
        for (int x : numbers) {
            System.out.println(x);
        }
        Arrays.sort(numbers);                   // You cannot use a Comparator with primitives
        System.out.println("Sorted ints: ");
        for (int x : numbers) {
            System.out.println(x);
        }
    }

    private static void populateList(DVDInfo[] dvdList) {    // again as it is static variable, we don't need to pass dvdList in
        // Read file using try with resources to avoid need to close
        try (BufferedReader br = new BufferedReader(
                new FileReader("src/main/java/Chapter6_Generics_and_Collections/Using_Collections/dvdinfo.txt"))) {
            String s;
            int index = 0;
            while ((s = br.readLine()) != null) {
                String[] splitString = s.split("/");
                dvdList[index] = new DVDInfo(splitString[0], splitString[1], splitString[2]);
                index++;
            }
        } catch (Exception x) { }
    }
}
