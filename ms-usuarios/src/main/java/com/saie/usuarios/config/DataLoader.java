package com.saie.usuarios.config;

import com.saie.usuarios.model.Usuario;
import com.saie.usuarios.repository.UsuarioRepository;
import net.datafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner cargarDatos(
            UsuarioRepository repository) {

        return args -> {

            if(repository.count() > 0){
                return;
            }

            Faker faker = new Faker();

            for(int i = 0; i < 20; i++){

                Usuario usuario = new Usuario();

                usuario.setNombre(
                        faker.name().fullName());

                usuario.setCorreo(
                        faker.internet().emailAddress());

                repository.save(usuario);
            }
        };
    }
}