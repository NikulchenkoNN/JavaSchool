package HomeWork16.dao;

import HomeWork16.Connection.DataSourceHelper;
import HomeWork16.Model.Animal;
import HomeWork16.Model.Person;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public class AnimalDaoImpl implements AnimalDao {
    private static final String INSERT_ANIMAL_SQL = "insert into animal (name, type) values (?, ?)";
    private static final String APDATE_ANIMAL_PERSON_SQL = "update animal set person_id = ? where id = ?";

    private PersonDao personDao;

    public AnimalDaoImpl(PersonDao personDao) {
        this.personDao = personDao;
    }

    @Override
    public Animal createAnimal(String name, String type) {
        try (PreparedStatement statement = DataSourceHelper.connection().prepareStatement(INSERT_ANIMAL_SQL)) {
            createAnimalStatement(statement, name, type);
            statement.execute();
            return findAnimal(name, type);
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }
    }

    @Override
    public Set<Animal> getAnimals() {
        return null;
    }

    @Override
    public void createAnimals(List<Animal> animals) {

    }

    @Override
    public Animal findAnimal(String name, String type) {
        return null;
    }

    @Override
    public void sellAnimal(Animal animal, Person person) {

    }
}
