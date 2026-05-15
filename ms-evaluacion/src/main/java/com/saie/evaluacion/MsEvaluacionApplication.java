package com.saie.evaluacion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MsEvaluacionApplication {

	public static void main(String[] args) {

		SpringApplication.run(
				MsEvaluacionApplication.class,
				args);
	}
}