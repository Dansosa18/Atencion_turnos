package umg.edu.gt.progra3.turnos.repository;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@ComponentScan(basePackages = {"umg.edu.gt.progra3.turnos.repository"})
@EnableJpaRepositories(basePackages = {"umg.edu.gt.progra3.turnos.repository.repositorys"})
@EnableMongoRepositories(basePackages = {"umg.edu.gt.progra3.turnos.repository.repositorys"})
@EntityScan(basePackages = {"umg.edu.gt.progra3.turnos.repository.model"})
public class ApplicationRepository {
}