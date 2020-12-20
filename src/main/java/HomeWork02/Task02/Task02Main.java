package HomeWork02.Task02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task02Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        List<Word> words = ReadFromFile.readFromFile(bufferedReader.readLine());
        bufferedReader.close();
        System.out.println(words);
        Collections.sort(words);
        System.out.println(words);
    }
}
