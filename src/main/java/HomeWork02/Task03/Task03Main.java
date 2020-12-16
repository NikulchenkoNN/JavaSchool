package HomeWork02.Task03;

import HomeWork02.Task01.UniqueWordsCounter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task03Main {
    public static void main(String[] args) throws IOException {
        BufferedReader nameReader = new BufferedReader(new InputStreamReader(System.in));
        List<String> words =  WordsCounter.counter(nameReader.readLine());
        Map<String, Integer> map = new HashMap();
        for (String w : words) {
            map.put(w, Collections.frequency(words, w));
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
