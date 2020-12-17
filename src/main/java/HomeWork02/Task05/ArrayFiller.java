package HomeWork02.Task05;

import java.util.ArrayList;
import java.util.List;

public class ArrayFiller {
    protected static List<String> init() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(String.valueOf(Math.random()*100));
        }
        return list;
    }
}
