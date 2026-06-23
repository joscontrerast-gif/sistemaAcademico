package com.saie.asistencia.controller;

import com.saie.asistencia.dto.AsistenciaRequestDTO;
import com.saie.asistencia.service.AsistenciaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Tag(name = "Asistencias", description = "Gestión de asistencias")
@RestController
@RequestMapping("/api/asistencias")
public class AsistenciaController {

    @Autowired
    private AsistenciaService service;

    @Operation(summary = "Listar todas las asistencias")
    @GetMapping
    public List<AsistenciaRequestDTO.AsistenciaDTO> listar() {
        return service.listar();
    }

    @Operation(summary = "Registrar una nueva asistencia")
    @PostMapping
    public ResponseEntity<AsistenciaRequestDTO.AsistenciaDTO> guardar(
            @RequestBody AsistenciaRequestDTO dto) {

        return ResponseEntity.ok(service.guardar(dto));
    }
}