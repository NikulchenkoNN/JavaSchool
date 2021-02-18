package HomeWork16.Service;

import HomeWork16.Connection.DataSourceHelper;
import HomeWork16.Model.Animal;
import HomeWork16.Model.Person;

import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AnimalPersonService {
    public static void addAnimalToPerson(Animal animal, Person person) {
        try (PreparedStatement statement = DataSourceHelper.connection().prepareStatement("update animal set person_id = ? where id = ?")) {
            statement.setInt(1, person.getId());
            statement.setInt(2, animal.getId());
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
