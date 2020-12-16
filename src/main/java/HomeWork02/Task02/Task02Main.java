package HomeWork02.Task02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task02Main {
    public static void main(String[] args) {
        List<Word> words = new ArrayList<>();
        words.add(new Word("privet"));
        words.add(new Word("priv"));
        words.add(new Word("allo"));
        words.add(new Word("ale"));
        System.out.println(words);
        Collections.sort(words);
        System.out.println(words);
    }
}
