package HomeWork17.api;

import HomeWork17.model.Person;

import java.util.List;

public interface BusinessLogic {
    void save(Person person);

    List<Person> getOlderThen(int age);
}
