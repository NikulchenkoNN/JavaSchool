package HomeWork09;


import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class StreamsTest {
    static List<Apples> apples = new ArrayList<>();
    static {
        apples.add(new Apples(10, "red"));
        apples.add(new Apples(5, "green"));
        apples.add(new Apples(7, "yellow"));
    }

    @Test
    public void testsForList() {
        List<Apples> list = new ArrayList<>(apples);
        System.out.println(Arrays.asList(apples));
        List<Apples> sortApples =  Streams.of(apples).filter(p -> p.getWeight() <9).transform(p-> new Apples(p.getWeight()+1, p.getColor())).toList();
        System.out.println(sortApples);
        Assert.assertArrayEquals(apples.toArray(), list.toArray());
    }


    @Test
    public void testsForMap() {
        System.out.println(Arrays.asList(apples));
        Map<String, Integer> sortApples =  Streams.of(apples).filter(p -> p.getWeight() <9).transform(p -> new Apples(p.getWeight(), p.getColor())).toMap(p->p.getColor(), p->p.getWeight());
        System.out.println(sortApples);
    }
}