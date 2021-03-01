package HomeWork17.canon;

import HomeWork17.api.Dao;
import HomeWork17.api.PKGenerator;
import HomeWork17.model.Person;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;

@Repository
public class OracleDao implements Dao {

    private PKGenerator generator;

    private Map<Long, Person> map = new ConcurrentHashMap<>();

    public OracleDao(PKGenerator generator) {
        this.generator = generator;
    }

    @Override
    public void insert(Person person) {
        long pk = generator.next();
        map.put(pk, person);
    }

    @Override
    public Stream<Person> select() {
        return map.values().stream();
    }
}
