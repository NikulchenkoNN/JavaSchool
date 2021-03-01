package HomeWork17.canon;

import HomeWork17.api.PKGenerator;
import org.springframework.stereotype.Component;

@Component
public class SimplePKGenerator implements PKGenerator {

    private static long id = 0;

    @Override
    public long next() {
        return ++id;
    }
}
