package HomeWork02.Task06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Task06Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Введите местоположение файла");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        List<String> list = StringNumberFinder.init(bufferedReader.readLine());
        bufferedReader.close();
        System.out.println("Введите номер строки");
        int n = Integer.parseInt(bufferedReader.readLine());
        System.out.println(StringNumberFinder.numberFinder(list, n));
    }
}
