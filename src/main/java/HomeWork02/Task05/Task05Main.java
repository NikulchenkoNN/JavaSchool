package HomeWork02.Task05;


import java.util.*;

public class Task05Main<T> implements Iterator {
    private static LinkedList<String> linkedList;

    public static void ReverseList(List<String> list) {
        linkedList = ArrayFiller.init();
        LinkedList<String> linkedList1 = linkedList;
        System.out.println(linkedList);
        System.out.println(linkedList1);
    }

    @Override
    public boolean hasNext() {
        return linkedList.peekLast() != null;
    }

    @Override
    public Object next() {
        return linkedList.pollLast();
    }

    public static void main(String[] args) {
        List<String> list = null;
        ReverseList(list);
    }
}
