package com.saie.evaluacion.controller;

import com.saie.evaluacion.dto.EvaluacionDTO;
import com.saie.evaluacion.dto.EvaluacionRequestDTO;
import com.saie.evaluacion.service.EvaluacionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/evaluaciones")
public class EvaluacionController {

    @Autowired
    private EvaluacionService service;

    @GetMapping
    public List<EvaluacionDTO> listar() {

        return service.listar();
    }

    @GetMapping("/{id}")
    public EvaluacionDTO obtener(
            @PathVariable Long id) {

        return service.obtener(id);
    }

    @PostMapping
    public EvaluacionDTO guardar(
            @RequestBody
            EvaluacionRequestDTO dto) {

        return service.guardar(dto);
    }

    @PutMapping("/{id}")
    public EvaluacionDTO actualizar(
            @PathVariable Long id,
            @RequestBody
            EvaluacionRequestDTO dto) {

        return service.actualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(
            @PathVariable Long id) {

        service.eliminar(id);
    }
}