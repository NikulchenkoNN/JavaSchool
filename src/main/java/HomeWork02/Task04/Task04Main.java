package HomeWork02.Task04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Task04Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        List<String> list = StringReader.reverseList(bufferedReader.readLine());
        for(String s : list) {
            System.out.println(s);
        }
    }
}
