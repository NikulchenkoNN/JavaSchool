package HomeWork17.client.spring;

import HomeWork17.api.BusinessLogic;
import HomeWork17.api.Dao;
import HomeWork17.api.PKGenerator;
import HomeWork17.canon.DefaultBusinessLogic;
import HomeWork17.canon.OracleDao;
import HomeWork17.canon.SimplePKGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public PKGenerator generator() {
        return new SimplePKGenerator();
    }

    @Bean
    public Dao dao(PKGenerator generator) {
        return new OracleDao(generator);
    }

    @Bean
    public BusinessLogic logic(Dao dao) {
        return new DefaultBusinessLogic(dao);
    }
}
