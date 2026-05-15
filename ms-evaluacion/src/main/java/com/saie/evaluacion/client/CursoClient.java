package com.saie.evaluacion.client;

import com.saie.evaluacion.dto.external.CursoDTO;

import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "ms-academico",
        url = "http://localhost:8082"
)
public interface CursoClient {

    @GetMapping("/api/cursos/{id}")
    CursoDTO obtenerCurso(
            @PathVariable Long id);
}