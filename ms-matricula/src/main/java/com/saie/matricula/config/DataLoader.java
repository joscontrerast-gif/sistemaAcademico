package com.saie.matricula.config;

import com.saie.matricula.model.Matricula;
import com.saie.matricula.repository.MatriculaRepository;
import net.datafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class DataLoader {
    @Bean
    CommandLineRunner cargarDatos(
            MatriculaRepository repository) {

        return args -> {

            if(repository.count() > 0){
                return;
            }
            Faker faker = new Faker();

            for(int i = 0; i < 20; i++){

                Matricula matricula = new Matricula();

                matricula.setEstudianteId(
                        faker.number().numberBetween(1L, 50L));
                matricula.setCursoId(
                        faker.number().numberBetween(1L, 20L));
                matricula.setFechaMatricula(
                        LocalDate.now());
                matricula.setEstado(
                        faker.options().option(
                                "ACTIVA",
                                "PENDIENTE",
                                "FINALIZADA"
                        )
                );
                repository.save(matricula);
            }
        };
    }
}