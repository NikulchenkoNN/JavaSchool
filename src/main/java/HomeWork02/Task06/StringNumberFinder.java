package HomeWork02.Task06;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StringNumberFinder {
    protected static List<String> init(String fileName) throws IOException {

        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        List<String> list = new ArrayList<>();
        while (fileReader.ready()) {
            list.add(fileReader.readLine());
        }
        return list;
    }
    protected static String numberFinder(List<String> list, int n) {
        return list.get(n);
    }
}
