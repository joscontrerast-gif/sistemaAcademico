package com.saie.evaluacion.config;

import com.saie.evaluacion.model.Evaluacion;
import com.saie.evaluacion.repository.EvaluacionRepository;
import net.datafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner cargarDatos(
            EvaluacionRepository repository) {

        return args -> {

            if (repository.count() > 0) {
                return;
            }

            Faker faker = new Faker();

            for (int i = 0; i < 20; i++) {

                Evaluacion evaluacion = new Evaluacion();

                evaluacion.setNombre(
                        faker.educator().course()
                );

                evaluacion.setAlumnoId(
                        faker.number().numberBetween(1L, 50L)
                );

                evaluacion.setCursoId(
                        faker.number().numberBetween(1L, 20L)
                );

                evaluacion.setPonderacion(
                        faker.number().randomDouble(2, 1, 100)
                );

                repository.save(evaluacion);
            }
        };
    }
}