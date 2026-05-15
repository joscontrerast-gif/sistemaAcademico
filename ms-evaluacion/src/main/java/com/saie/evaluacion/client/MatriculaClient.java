package com.saie.evaluacion.client;

import com.saie.evaluacion.dto.external.MatriculaDTO;

import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "ms-matricula",
        url = "http://localhost:8083"
)
public interface MatriculaClient {

    @GetMapping("/api/matriculas/{id}")
    MatriculaDTO obtenerMatricula(
            @PathVariable Long id);
}