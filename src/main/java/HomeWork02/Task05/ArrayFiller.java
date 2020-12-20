package HomeWork02.Task05;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrayFiller {
    protected static LinkedList<String> init() {
        LinkedList<String> list = new LinkedList<>();
        for (int i = 0; i < 20; i++) {
            list.add(String.valueOf(Math.random()*100));
        }
        return list;
    }
}
