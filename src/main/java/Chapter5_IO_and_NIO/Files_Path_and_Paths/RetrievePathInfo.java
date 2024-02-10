package Chapter5_IO_and_NIO.Files_Path_and_Paths;

import java.nio.file.Path;
import java.nio.file.Paths;

public class RetrievePathInfo {
    public static void main(String[] args) {
        Path path = Paths.get("/Users/joe/OCA_Java_1Z0_809/searchThis/file2.txt");

        System.out.println("getFileName: " + path.getFileName());
        System.out.println("getName(1): " + path.getName(1));
        System.out.println("getNameCount: " + path.getNameCount());

        System.out.println("getParent: " + path.getParent());
        System.out.println("getRoot " + path.getRoot());
        System.out.println("subPath(0, 2):" + path.subpath(0, 2));
        System.out.println("toString: " + path.toString());
        System.out.println(path);

        // ITERATE A PATH
        int spaces = 1;
        Path myPath = Paths.get("temp", "dir1", "dir2", "dir3", "file.txt");
        for (Path subPath : myPath) {
            System.out.format("%" + spaces + "s%s%n", "", subPath);
            spaces += 2;
        }
        // produces:
        // temp
        //   dir1
        //     dir2
        //       dir3
        //         file.txt

    }
}
