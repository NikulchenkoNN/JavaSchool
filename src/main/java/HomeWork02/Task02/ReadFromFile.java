package HomeWork02.Task02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFromFile {
    protected static List<Word> readFromFile(String fileName) throws IOException {
    protected static List<Word> reader(String fileName) throws IOException {
        List<Word> words = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        while (bufferedReader.ready()) {
            String[] line = bufferedReader.readLine().split(" ");
            for (String str : line) {
                words.add(new Word(str));
            }
        }
        bufferedReader.close();
        return words;
    }
}
