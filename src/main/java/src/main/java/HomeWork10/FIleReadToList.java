package HomeWork10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FIleReadToList {
    public List<Integer> readToList(String fileName) throws IOException {
        List<Integer> result = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            result.add(Integer.parseInt(line));
        }
        bufferedReader.close();
        return result;
    }
}
