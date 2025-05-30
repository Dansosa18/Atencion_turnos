package umg.edu.gt.progra3.turnos.api.config;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI turnosOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("API Turnos")
                        .description("Sistema de gestión de turnos con Spring Boot + RabbitMQ")
                        .version("v1.0"));
    }
}

