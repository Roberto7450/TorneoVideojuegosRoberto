package es.iesjuanbosco.roberto.torneovideojuegosroberto.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

@Configuration
public class DatabaseInitConfig {

    @Bean
    CommandLineRunner initDatabase(DataSource dataSource) {
        return args -> {
            try (Connection conn = dataSource.getConnection();
                 Statement stmt = conn.createStatement()) {

                // Verificar si ya existen datos en varias tablas
                ResultSet rs1 = stmt.executeQuery("SELECT COUNT(*) FROM juegos");
                rs1.next();
                long juegosCount = rs1.getLong(1);

                ResultSet rs2 = stmt.executeQuery("SELECT COUNT(*) FROM equipos");
                rs2.next();
                long equiposCount = rs2.getLong(1);

                ResultSet rs3 = stmt.executeQuery("SELECT COUNT(*) FROM jugadores");
                rs3.next();
                long jugadoresCount = rs3.getLong(1);

                ResultSet rs4 = stmt.executeQuery("SELECT COUNT(*) FROM torneos");
                rs4.next();
                long torneosCount = rs4.getLong(1);

                boolean dbEmpty = juegosCount == 0 && equiposCount == 0 &&
                        jugadoresCount == 0 && torneosCount == 0;

                if (dbEmpty) {
                    ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
                    populator.addScript(new ClassPathResource("data.sql"));
                    populator.execute(dataSource);
                    System.out.println("Datos iniciales cargados correctamente");
                } else {
                    System.out.println("Base de datos ya contiene datos, omitiendo carga inicial");
                }
            }
        };
    }
}
