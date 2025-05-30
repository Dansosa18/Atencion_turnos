package umg.edu.gt.progra3.turnos.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"umg.edu.gt.progra3.turnos"})
public class TuApplicationPrincipal {
	public static void main(String[] args) {
		SpringApplication.run(TuApplicationPrincipal.class, args);
	}
}
