package com.saie.evaluacion.client;

import com.saie.evaluacion.dto.external.AcademicoDTO;

import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "academico-client")
public interface AcademicoClient {

    @GetMapping("/api/academicos/{id}")
    AcademicoDTO obtenerAcademico(@PathVariable("id") Long id);
}