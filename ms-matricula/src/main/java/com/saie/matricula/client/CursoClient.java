package com.saie.matricula.client;

import com.saie.matricula.dto.external.AcademicoDTO;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "ms-academico",
        url = "http://localhost:8082"
)
public interface CursoClient {

    @GetMapping("/api/academicos/{id}")
    AcademicoDTO obtenerCurso(
            @PathVariable Long id);
}