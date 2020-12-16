package HomeWork02.Task02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task02Main {
    public static void main(String[] args) {
        List<Word> words = new ArrayList<>();
        words.add(new Word("mama"));
        words.add(new Word("mila"));
        words.add(new Word("milom"));
        words.add(new Word("ramu"));
        words.add(new Word("mil"));
        words.add(new Word("milloin"));

        System.out.println(words);
        System.out.println();
        Collections.sort(words);
        System.out.println(words);
    }
    
}
