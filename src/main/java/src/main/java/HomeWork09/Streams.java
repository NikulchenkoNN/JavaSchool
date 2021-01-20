package HomeWork09;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams<T> {
    private Stream<T> streams;

    public Streams(Stream stream) {
        this.streams = stream;
    }

    public static <T> Streams<T> of(List<T> list) {
        return new Streams<>(list.stream());
    }

    public Streams<T> filter(Predicate<? super T> predicate) {
        return new Streams<T>(streams.filter(predicate));
    }

    public <R> Streams<R> transform(Function<? super T, ? extends R> function) {
        return new Streams<>(streams.map(function));
    }

    public <K, V> Map<K, V> toMap(Function<? super T, ? extends K> keyMapper,
                               Function<? super T, ? extends V> valueMapper) {

        return streams.collect(Collectors.toMap(keyMapper, valueMapper));
    }

    public List<T> toList() {
        return  streams.collect(Collectors.toList());
    }

}
