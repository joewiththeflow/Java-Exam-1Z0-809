package Chapter5_IO_and_NIO;

import java.io.File;
import java.io.IOException;

public class FileDirectoryExample3 {
    public static void main(String[] args) {

        File delDir = new File("delDir");
        delDir.mkdir();

        File delFile1 = new File(delDir, "delFile1.txt");

        try {
            delFile1.createNewFile();       // we need to have try catch when creating a new file

            File delFile2 = new File(delDir, "delFile2.txt");
            delFile2.createNewFile();       // add file
            delFile1.delete();
            System.out.println("delDir is " + delDir.delete());     // attempt to delete directory

            File newName = new File(delDir, "newName.txt");     // new File object
            delFile2.renameTo(newName);                               // rename File

            File newDir = new File("newDir2");               // rename directory
                                                            // WILL ONLY WORK IF DIR DOESNT ALREADY EXIST !!!!
                                                            // ORIGINAL delDir disappears as it has been renamed
            System.out.println(delDir.renameTo(newDir));

            // First run - end up with newDir/newName.txt

            //1. delDir directory created
            //2. delFile1.txt created
            //3. delFile2.txt created
            //4. delFile1.txt deleted
            //5. delDir attempted to be deleted but fails - "delDir is false"
            //6. delFile2.txt renamed to "newName.txt"
            //7. delDir renamed to "newDir

            // Second run - still have newDir/newName.txt but also have delDir/newName.txt
            //              because the attempt to rename delDir to newDir fails as newDir already exists this time

            //1. delDir directory created
            //2. delFile1.txt created
            //3. delFile2.txt created
            //4. delFile1.txt deleted
            //5. delDir attempted to be deleted but fails - "delDir is false"
            //6. delFile2.txt renamed to "newName.txt"
            //7. delDir attempted to be renamed but fails - "false"

            // You can't deleted a directory if it is not empty
            // You must give a new File object with the name you want to renameTo()
            // It's ok to rename a directory even if it is not empty

        } catch (IOException e) { }


    }
}
