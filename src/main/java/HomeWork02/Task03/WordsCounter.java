package HomeWork02.Task03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class WordsCounter {
    protected static List<String> counter(String fileName) throws IOException {
        List<String> words = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        while (bufferedReader.ready()) {
            String[] line = bufferedReader.readLine().toLowerCase(Locale.ROOT).replaceAll(".^[\\D]", " ").split(" ");
            for (String word : line) {
                if (!(word.equals(""))) {
                    words.add(word);
                }
            }
        }
        return words;
    }
}
