package Homewrok16;

import HomeWork16.Connection.DataSourceHelper;
import HomeWork16.Model.Animal;
import HomeWork16.Model.Person;
import HomeWork16.Service.AnimalPersonService;
import HomeWork16.dao.AnimalDao;
import HomeWork16.dao.AnimalDaoImpl;
import HomeWork16.dao.PersonDao;
import HomeWork16.dao.PersonDaoImpl;
import org.h2.tools.Server;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Set;

public class StatementTests {

    private static PersonDao personDao;
    private static AnimalDao animalDao;

    @BeforeAll
    public static void createDao() throws SQLException {
        DataSourceHelper.createDb();

        personDao = new PersonDaoImpl();
        animalDao = new AnimalDaoImpl(personDao);

        Server.createTcpServer().start();
    }

    @BeforeEach
    public void beforeEachTest() {
        try (Statement statement = DataSourceHelper.connection().createStatement()) {
            statement.executeUpdate("truncate table ANIMAL");
            statement.executeUpdate("truncate table PERSON");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void insertAndGetAnimal() {
        Animal catMurka = animalDao.createAnimal("Мурка", "кот");
        Animal catBarsic = animalDao.createAnimal("Барсик", "кот");
        Animal catRjic = animalDao.createAnimal("Рыжик", "кот");
        Animal dogReks = animalDao.createAnimal("Рекс", "собака");

        Person manSergei = personDao.createPerson("Сергей", 12);
        Person manPetr = personDao.createPerson("Петр", 42);

        AnimalPersonService.addAnimalToPerson(catBarsic, manSergei);
        AnimalPersonService.addAnimalToPerson(catRjic, manSergei);
        AnimalPersonService.addAnimalToPerson(dogReks, manSergei);
        AnimalPersonService.addAnimalToPerson(catMurka, manPetr);

        Set<Animal> animals = animalDao.getAnimals();
        Set<Person> persons = personDao.getPersons();

        System.out.println("Животные");
        animals.forEach(System.out::println);

        System.out.println("\nЛюди");
        persons.forEach(System.out::println);
    }


    @Test
    public void createSeveralAnimals() {
        animalDao.createAnimals(Arrays.asList(
                Animal.create("Борис", "ёж"),
                Animal.create("Гуля", "голубь"),
                Animal.create("Гена", "крокодил")));

        System.out.println(animalDao.getAnimals());
    }

    @Test
    public void h2CursorAvailability() {
        try (Connection connection = DataSourceHelper.connection()) {
            DatabaseMetaData metaData = connection.getMetaData();

            System.out.println("Движение курсора");
            System.out.println(metaData.supportsResultSetType(ResultSet.TYPE_FORWARD_ONLY));
            System.out.println(metaData.supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE));
            System.out.println(metaData.supportsResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE));

            System.out.println("Движение курсора с конкурентным доступом");
            System.out.println(metaData.supportsResultSetConcurrency(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY));
            System.out.println(metaData.supportsResultSetConcurrency(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE));

            System.out.println(metaData.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY));
            System.out.println(metaData.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE));

            System.out.println(metaData.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY));
            System.out.println(metaData.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE));

            System.out.println("Действия с курсором после коммита");
            System.out.println(metaData.supportsResultSetHoldability(ResultSet.HOLD_CURSORS_OVER_COMMIT));
            System.out.println(metaData.supportsResultSetHoldability(ResultSet.CLOSE_CURSORS_AT_COMMIT));
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Test
    public void sellAnimal() {
        Animal tiger = animalDao.createAnimal("Пушистик", "тигр");
        Person personIvan = personDao.createPerson("Иван", 30);
        Person personPetr = personDao.createPerson("Петр", 20);

        AnimalPersonService.addAnimalToPerson(tiger, personIvan);
        animalDao.sellAnimal(tiger, personPetr);

        tiger = animalDao.findAnimal("Пушистик", "тигр");

        // без ошибки
        Assertions.assertEquals(personPetr, tiger.getPerson());
        // с ошибкой во время транзации
//        Assertions.assertEquals(personIvan, tiger.getPerson());
    }


}
