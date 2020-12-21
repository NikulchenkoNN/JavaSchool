package HomeWork03;

import java.util.HashMap;
import java.util.Map;

public class CountMapImpl<T> implements CountMap<T> {
    Map<T, Integer> map = new HashMap<>();

    public void add(T o) {
        if (!this.map.containsKey(o)) {
            this.map.put(o, 1);
        } else {
            int value = this.map.get(o) + 1;
            this.map.put(o, value);
        }
    }

    @Override
    public int getCount(T o) {
        return this.map.get(o);
    }

    @Override
    public int remove(T o) {
        return this.map.remove(o);
    }

    @Override
    public int size() {
        return this.map.size();
    }

    @Override
    public Map toMap() {
        Map<T, Integer> mapa = new HashMap<>();
        for (Map.Entry<T, Integer> obj : this.map.entrySet()) {
            mapa.put((T) obj, getCount((T) obj));
        }
        return mapa;
    }

    @Override
    public void toMap(Map destination) {
        destination.putAll(this.map);
    }

    @Override
    public void addAll(CountMapImpl<T> source) {
        map.putAll(source.toMap());
    }

    public static void main(String[] args) {
        CountMap<Integer> map = new CountMapImpl<>();

        map.add(10);
        map.add(10);
        map.add(5);
        map.add(6);
        map.add(5);
        map.add(10);


        int count1 = map.getCount(5); // 2
        int count2 = map.getCount(6); // 1
        int count3 = map.getCount(10); // 3
        System.out.println(count1);
        System.out.println(count2);
        System.out.println(count3);

    }
}
