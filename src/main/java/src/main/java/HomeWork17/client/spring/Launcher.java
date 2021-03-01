package HomeWork17.client.spring;

import HomeWork17.api.BusinessLogic;

import HomeWork17.model.Person;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Launcher {

    private static final Logger LOGGER = LoggerFactory.getLogger(Launcher.class);

    public static void main(String[] args) {

//        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        ApplicationContext context = new AnnotationConfigApplicationContext(AnnotationConfig.class);
        BusinessLogic logic = context.getBean(BusinessLogic.class);

        logic.save(new Person("Bob", 25));
        logic.save(new Person("Martin", 80));

        List<Person> list = logic.getOlderThen(30);

        LOGGER.info("result {}", list);
    }
}
