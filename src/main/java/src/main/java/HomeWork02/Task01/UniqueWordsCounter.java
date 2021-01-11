package HomeWork02.Task01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class UniqueWordsCounter {
    protected static Set<String> reader(String fileName) throws IOException {
        Set<String> words = new HashSet<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        while (bufferedReader.ready()) {
            String[] line = bufferedReader.readLine().toLowerCase(Locale.ROOT).replaceAll("\\d", " ").replaceAll("\\t", " ").split(" ");
            for (String word : line) {
                if (!(word.equals(""))) {
                    words.add(word);
                }
            }
        }
        bufferedReader.close();
        return words;
    }
}
