package com.saie.matricula.client;

import com.saie.matricula.dto.external.CursoDTO;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(
        name = "ms-academico",
        url = "http://localhost:8082")

public interface CursoClient {

    @GetMapping("/api/cursos/{id}")
    CursoDTO obtenerCurso(
            @PathVariable Long id);
}