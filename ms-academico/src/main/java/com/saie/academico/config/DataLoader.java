package com.saie.academico.config;

import com.saie.academico.model.Academico;
import com.saie.academico.repository.AcademicoRepository;
import net.datafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner cargarDatos(
            AcademicoRepository repository) {

        return args -> {

            if(repository.count() > 0){
                return;
            }

            Faker faker = new Faker();

            for(int i = 0; i < 20; i++){

                Academico academico =
                        new Academico();

                academico.setNombre(
                        faker.educator().university()
                );

                academico.setCarrera(
                        faker.educator().course()
                );

                academico.setAsignatura(
                        faker.educator().course()
                );

                academico.setPromedio(
                        faker.number().randomDouble(
                                2,
                                10,
                                70
                        )
                );

                repository.save(academico);
            }
        };
    }
}