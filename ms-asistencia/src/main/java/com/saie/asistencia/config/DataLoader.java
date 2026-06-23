package com.saie.asistencia.config;

import net.datafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Override
    public void run(String... args) {

        Faker faker = new Faker();

        System.out.println("Alumno: " + faker.name().fullName());
        System.out.println("Curso: " + faker.educator().course());
    }
}