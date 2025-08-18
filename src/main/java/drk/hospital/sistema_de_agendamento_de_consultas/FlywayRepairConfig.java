package drk.hospital.sistema_de_agendamento_de_consultas;

import org.flywaydb.core.Flyway;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FlywayRepairConfig {
    @Bean
    CommandLineRunner repairFlyway(Flyway flyway) {
        return args -> {
            flyway.repair();
            System.out.println("✅ Flyway repair executado com sucesso");
        };
    }
}
