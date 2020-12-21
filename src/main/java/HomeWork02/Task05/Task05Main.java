package HomeWork02.Task05;


import java.util.*;

public class Task05Main<T> implements Iterator {
    public LinkedList linkedList;

    public void ReverseList(List<T> list) {
        this.linkedList = ArrayFiller.init();
        System.out.println(linkedList);
        for (T obj:
             list) {
            this.linkedList.push(obj);
        }
    }

    @Override
    public boolean hasNext() {
        return linkedList.peekLast() != null;
    }

    @Override
    public Object next() {
        return linkedList.peekLast();
    }
}
