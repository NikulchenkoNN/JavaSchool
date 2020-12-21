package HomeWork02.Task05;

import java.util.LinkedList;

public class ArrayFiller {
    protected static LinkedList<String> init() {
        LinkedList<String> list = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            list.add(String.valueOf(Math.random()*100));
        }
        return list;
    }
}
