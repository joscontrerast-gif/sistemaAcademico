package com.saie.asistencia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MsAsistenciaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsAsistenciaApplication.class, args);
	}
}