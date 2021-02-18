package HomeWork16.dao;

import HomeWork16.Model.Person;

import java.util.Set;

public interface PersonDao {
    Person findPersonById(int personId);
    Person createPerson(String name, int age);
    Set<Person> getPersons();
}
