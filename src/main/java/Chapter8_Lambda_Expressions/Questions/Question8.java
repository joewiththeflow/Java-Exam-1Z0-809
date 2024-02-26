package Chapter8_Lambda_Expressions.Questions;

import java.util.Arrays;
import java.util.List;

public class Question8 {

    public static void main(String[] args) {

        List<String> birds = Arrays.asList("eagle", "seagull", "albatross", "buzzard", "goose");
        int longest = 0;
        birds.forEach(b -> {
            if (b.length() > longest) {
//                longest = b.length();             -- has to be final or effectively final
            }
        });
        System.out.println("Longest bird name is length: " + longest);

//        What is the result?

//        A. "Longest bir name is length: 9"
//        B. Compilation fails because of an error on Line L5       ---> CORRECT
//        C. Compilation fails because of an error on Line L3
//        D. A runtime exception occurs on Line L5
    }
}
