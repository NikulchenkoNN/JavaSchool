package HomeWork03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionUtils {
    public static <T> void addAll(List<? extends T> source, List<? super T> destination) {
        destination.addAll(source);
    }

    public static <T> List<? extends T> newArrayList() {
        return new ArrayList<>();
    }

    public static <T> int indexOf(List<? extends T> source, Object o) {
        return source.indexOf(o);
    }

    public static <T> List<? super T> limit(List<? extends T> source, int size) {
        List<? super T> dest = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            dest.add(source.get(i));
        }
        return dest;
    }

    public static <T> void add(List<T> source, Object o) {
        source.add((T) o);
    }

    public static <T> void removeAll(List<? super T> removeFrom, List<? extends T> c2) {
        removeFrom.removeAll(c2);
    }

    public static <T> boolean containsAll(List<? extends T> c1, List<? extends T> c2) {
        return c1.containsAll(c2);
    }

    public static <T> boolean containsAny(List<? extends T> c1, List<? extends T> c2) {
        for (Object t : c2) {
            if (!c1.contains(t)) {
                return false;
            }
        }
        return true;
    }

    public static <T extends Comparable<? super T>> List<T> range(List<? extends T> list, T min, T max) {
        Collections.sort(list);
        List<T> result = new ArrayList<>();
        for (T t :
                list) {
            if (t.compareTo(min) >= 0 && t.compareTo(max) <= 0) {
                result.add(t);
            }
        }
        return result;
    }

    public static <T extends Comparable<? super T>> List<T> range(List<? extends T> list, T min, T max, Comparator comparator) {
        List<T> result = new ArrayList<>();
        for (T t :
                list) {
            if (comparator.compare(t, min) >= 0 && comparator.compare(t, max) <= 0) {
                result.add(t);
            }
        }
        return result;
    }
}