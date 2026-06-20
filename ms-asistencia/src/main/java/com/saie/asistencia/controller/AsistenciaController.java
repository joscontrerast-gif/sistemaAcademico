package com.saie.asistencia.controller;

import com.saie.asistencia.dto.AsistenciaRequestDTO;

import com.saie.asistencia.service.AsistenciaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/asistencias")
public class AsistenciaController {

    @Autowired
    private AsistenciaService service;

    @GetMapping
    public List<AsistenciaRequestDTO.AsistenciaDTO> listar() {
        return service.listar();
    }

    @PostMapping
    public ResponseEntity<AsistenciaRequestDTO.AsistenciaDTO> guardar(@RequestBody AsistenciaRequestDTO dto) {

        return ResponseEntity.ok(service.guardar(dto));
    }
}