package HomeWork17.canon;


import HomeWork17.api.BusinessLogic;
import HomeWork17.api.Dao;
import HomeWork17.model.Person;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DefaultBusinessLogic implements BusinessLogic {

    private Dao oracleDao;

    public DefaultBusinessLogic(Dao oracleDao) {
        this.oracleDao = oracleDao;
    }

    @Override
    public void save(Person person) {
        if (person.getAge() < 20) {
            throw new IllegalArgumentException("Too young");
        }

        oracleDao.insert(person);
    }

    @Override
    public List<Person> getOlderThen(int age) {
        return oracleDao.select().filter(it -> it.getAge() > age).collect(Collectors.toList());
    }

}
