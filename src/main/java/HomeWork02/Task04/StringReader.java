package HomeWork02.Task04;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StringReader {
    protected static List<String> reverseList(String fileName) throws IOException {
        List<String> list = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        while (bufferedReader.ready()) {
            list.add(bufferedReader.readLine());
        }
        Collections.reverse(list);
        return list;
    }
}
