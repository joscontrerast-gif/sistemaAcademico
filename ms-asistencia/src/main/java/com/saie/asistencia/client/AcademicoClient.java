package com.saie.asistencia.client;

import com.saie.asistencia.dto.external.AcademicoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-academico", url = "http://localhost:8082")
public interface AcademicoClient {

    @GetMapping("/api/academicos/{id}")
    AcademicoDTO obtenerAcademico(@PathVariable Long id);
}