package HomeWork08;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class ReadData {
    public static Map<String, Object> reader(String fileName) {

        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(fileName));
        } catch (IOException e) {
            File file = new File(fileName);
            return new HashMap<>();
        }
        try {
            return  (Map<String, Object>) objectInputStream.readObject();
        } catch (IOException e) {
            return new HashMap<>();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new HashMap<>();
    }
}
