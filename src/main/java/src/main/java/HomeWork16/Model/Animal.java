package HomeWork16.Model;

import java.util.Objects;

public class Animal {
    private Integer id;
    private String name;
    private String type;
    private Person person;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static Animal create(String name, String type) {
        Animal animal = new Animal();
        animal.setName(name);
        animal.setType(type);
        return animal;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Animal animal = (Animal) obj;
        return id.equals(animal.id);
    }

    @Override
    public String toString() {
        return "Animal{" + "id= " + id + ", name= " + name + '\'' + ", type= " + type + '\'' +
                (person != null ? ", person={id" + person.getId() + "}" : "");
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
