package HomeWork02.Task01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Task01Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Введите местоположение файла");
        BufferedReader nameReader = new BufferedReader(new InputStreamReader(System.in));
        Set<String> words =  UniqueWordsCounter.reader(nameReader.readLine());
        System.out.println(words.size());
        System.out.println(words);


    }


}
