package HomeWork01.BubbleSorter;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        BubbleSorter.arrayFiller(list, 10);
        System.out.print(list);
        BubbleSorter.arraySorter(list);
        System.out.println();
        System.out.println(list);
    }
}