package HomeWork08;

import java.io.*;
import java.util.Map;

public class SaveData {
    public static void saver(Object obj, String fileName) {
        File file = new File(fileName);
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file)))
        {
            objectOutputStream.writeObject(obj);}
         catch (IOException e) {
            e.printStackTrace();
        }
    }
}
