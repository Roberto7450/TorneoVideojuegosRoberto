package es.iesjuanbosco.roberto.torneovideojuegosroberto.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Torneo Videojuegos API",
                version = "1.0.0",
                description = "API REST para la gestión de torneos de videojuegos. " +
                        "Permite gestionar jugadores, torneos, inscripciones, equipos y juegos.",
                contact = @Contact(
                        name = "Roberto",
                        email = "roberto@iesjuanbosco.es"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "https://www.apache.org/licenses/LICENSE-2.0.html"
                )
        ),
        servers = {
                @Server(
                        description = "Servidor Local",
                        url = "http://localhost:8080"
                )
        }
)
public class OpenApiConfig {
}
