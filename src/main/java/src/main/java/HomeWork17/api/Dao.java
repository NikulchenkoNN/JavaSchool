package HomeWork17.api;

import HomeWork17.model.Person;

import java.util.stream.Stream;

public interface Dao {
    void insert(Person person);

    Stream<Person> select();
}
