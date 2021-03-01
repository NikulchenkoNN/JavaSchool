package HomeWork16.dao;

import HomeWork16.Model.Animal;
import HomeWork16.Model.Person;

import java.util.List;
import java.util.Set;

public interface AnimalDao {
    Animal createAnimal(String name, String type);
    Set<Animal> getAnimals();
    void createAnimals(List<Animal> animals);
    Animal findAnimal(String name, String type);
    void sellAnimal(Animal animal, Person person);
}
