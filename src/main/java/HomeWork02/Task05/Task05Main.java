package HomeWork02.Task05;

import HomeWork02.Task05.ArrayFiller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Task05Main {
    public static void main(String[] args) {
        List<String> list = ArrayFiller.init();
        List<String> reverseList = new ArrayList<>();
        reverseList.addAll(list);
        Collections.reverse(reverseList);
        for (String str :
                list) {
            System.out.println(str);
        }
        System.out.println();
        for (String str :
                reverseList) {
            System.out.println(str);
        }
        System.out.println();
        //alternative way to reverse List
        LinkedList<String> linkList = new LinkedList<>();
        linkList.addAll(list);
        String s;
        while ((s = linkList.pollLast()) != null) {
            System.out.println(s);
        }
    }
}
