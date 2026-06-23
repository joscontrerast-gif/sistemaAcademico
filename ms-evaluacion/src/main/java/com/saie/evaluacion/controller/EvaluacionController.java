package com.saie.evaluacion.controller;

import com.saie.evaluacion.dto.EvaluacionDTO;
import com.saie.evaluacion.dto.EvaluacionRequestDTO;
import com.saie.evaluacion.service.EvaluacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;



import java.util.List;

@Tag(name = "Evaluaciones", description = "Gestión de evaluaciones")
@RestController
@RequestMapping("/api/evaluaciones")
public class EvaluacionController {

    @Autowired
    private EvaluacionService service;

    @Operation(summary = "Listar evaluaciones")

    @GetMapping
    public List<EvaluacionDTO> listar() {

        return service.listar();
    }

    @Operation(summary = "Obtener evaluación por ID")

    @GetMapping("/{id}")
    public EvaluacionDTO obtener(
            @PathVariable Long id) {

        return service.obtener(id);
    }

    @Operation(summary = "Crear evaluación")

    @PostMapping
    public EvaluacionDTO guardar(
            @RequestBody
            EvaluacionRequestDTO dto) {

        return service.guardar(dto);
    }

    @Operation(summary = "Actualizar evaluación")

    @PutMapping("/{id}")
    public EvaluacionDTO actualizar(
            @PathVariable Long id,
            @RequestBody
            EvaluacionRequestDTO dto) {

        return service.actualizar(id, dto);
    }

    @Operation(summary = "Eliminar evaluación")

    @DeleteMapping("/{id}")
    public void eliminar(
            @PathVariable Long id) {

        service.eliminar(id);
    }

}