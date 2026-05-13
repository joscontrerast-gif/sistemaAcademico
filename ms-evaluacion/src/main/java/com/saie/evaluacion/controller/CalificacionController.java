package com.saie.evaluacion.controller;

import com.saie.evaluacion.dto.CalificacionDTO;
import com.saie.evaluacion.dto.CalificacionRequestDTO;
import com.saie.evaluacion.service.CalificacionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/calificaciones")
class CalificacionController {

    @Autowired
    private CalificacionService service;

    @GetMapping
    public List<CalificacionDTO> listar() {

        return service.listar();
    }

    @GetMapping("/{id}")
    public CalificacionDTO obtener(
            @PathVariable Long id) {

        return service.obtener(id);
    }

    @PostMapping
    public CalificacionDTO guardar(
            @RequestBody
            CalificacionRequestDTO dto) {

        return service.guardar(dto);
    }

    @PutMapping("/{id}")
    public CalificacionDTO actualizar(
            @PathVariable Long id,
            @RequestBody
            CalificacionRequestDTO dto) {

        return service.actualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(
            @PathVariable Long id) {

        service.eliminar(id);
    }
}