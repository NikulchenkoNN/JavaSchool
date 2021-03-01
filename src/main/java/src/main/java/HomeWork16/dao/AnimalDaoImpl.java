package HomeWork16.dao;

import HomeWork16.Connection.DataSourceHelper;
import HomeWork16.Model.Animal;
import HomeWork16.Model.Person;

import java.sql.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AnimalDaoImpl implements AnimalDao {
    private static final String INSERT_ANIMAL_SQL = "insert into animal (name, type) values (?, ?)";
    private static final String UPDATE_ANIMAL_PERSON_SQL = "update animal set person_id = ? where id = ?";

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

    private void createAnimalStatement(PreparedStatement statement, String name, String type) throws SQLException {
        statement.setString(1, name);
        statement.setString(2, type);
    }

    @Override
    public Set<Animal> getAnimals() {
        try (Statement statement = DataSourceHelper.connection().createStatement()) {
            statement.execute("select *, (select * from person p where p.id = a.person_id) from animal a");
            ResultSet resultSet = statement.getResultSet();
            Set<Animal> animals = new HashSet<>();
            while (resultSet.next()) {
                animals.add(resultSetForAnimal(resultSet));
            }

            return animals;
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }
    }

    private Animal resultSetForAnimal(ResultSet resultSet) throws SQLException {
        Animal animal = new Animal();
        animal.setId(resultSet.getInt(1));
        animal.setName(resultSet.getString(2));
        animal.setType(resultSet.getString(3));

        int personId = resultSet.getInt(4);
        if (!resultSet.wasNull()) {
            animal.setPerson(personDao.findPersonById(personId));
        }
        return animal;
    }

    @Override
    public void createAnimals(List<Animal> animals) {
        try (PreparedStatement statement = DataSourceHelper.connection().prepareStatement(INSERT_ANIMAL_SQL)) {
            for (Animal pair : animals) {
                createAnimalStatement(statement, pair.getName(), pair.getType());
                statement.addBatch();
            }
            statement.executeBatch();
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }
    }

    @Override
    public Animal findAnimal(String name, String type) {
        try (PreparedStatement statement = DataSourceHelper.connection().prepareStatement("select * from animal a where a.name=? and a.type=?")) {
            statement.setString(1, name);
            statement.setString(2, type);
            statement.execute();

            ResultSet resultSet = statement.getResultSet();
            resultSet.next();

            return resultSetForAnimal(resultSet);
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }
    }

    @Override
    public void sellAnimal(Animal animal, Person person) {
        try (Connection connection = DataSourceHelper.connection()) {
            connection.setAutoCommit(false);

            Savepoint savepoint = connection.setSavepoint();
            try {
                PreparedStatement statement = connection.prepareStatement(UPDATE_ANIMAL_PERSON_SQL);

                statement.setInt(1, person.getId());
                statement.setInt(2, animal.getId());

                statement.execute();

                if (false) {
                    throw new RuntimeException();
                }

                connection.commit();
            } catch (Exception throwables) {
                connection.rollback(savepoint);
            }
        } catch (SQLException throwables) {
            throw new RuntimeException();
        }
    }
}
