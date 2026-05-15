package com.saie.academico;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MsAcademicoApplication {

	public static void main(String[] args) {

		SpringApplication.run(
				MsAcademicoApplication.class,
				args);
	}
}