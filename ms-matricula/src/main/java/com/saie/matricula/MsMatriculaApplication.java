package com.saie.matricula;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MsMatriculaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsMatriculaApplication.class, args);
	}
}