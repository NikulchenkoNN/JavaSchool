package HomeWork03.CountMap;

import java.util.Map;

public interface  CountMap<T> {
    void add(T o);

    int getCount(T o);

    //current count
    int remove(T o);

    int size();

    void addAll(CountMapImpl<T> source);

    Map toMap();

    void toMap(Map destination);


}
