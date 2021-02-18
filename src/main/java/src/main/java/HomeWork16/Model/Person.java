package HomeWork16.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Person {
    private Integer id;
    private Integer age;
    private String name;
    private List<Animal> animals = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Person person = (Person) obj;
        return id.equals(person.id);
    }

    @Override
    public String toString() {
        return "Animal{" + "id= " + id + ", name= " + name + '\'' +
                (!animals.isEmpty() ? ", animals=" + animals : "");
    }
}
