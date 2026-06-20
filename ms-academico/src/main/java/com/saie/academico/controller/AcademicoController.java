package com.saie.academico.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saie.academico.dto.AcademicoDTO;
import com.saie.academico.dto.AcademicoRequestDTO;

import com.saie.academico.service.AcademicoService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/academicos")
public class AcademicoController {

    @Autowired
    private AcademicoService service;

    @GetMapping
    public ResponseEntity<List<AcademicoDTO>> listar() {

        return ResponseEntity.ok(
                service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AcademicoDTO> obtener(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                service.obtener(id));
    }

    @PostMapping
    public ResponseEntity<AcademicoDTO> guardar(
            @RequestBody AcademicoRequestDTO dto) {
        System.out.println("Nombre: " + dto.getNombre());
        System.out.println("Carrera: " + dto.getCarrera());
        System.out.println("Asignatura: " + dto.getAsignatura());
        System.out.println("Promedio: " + dto.getPromedio());

        return ResponseEntity.status(
                        HttpStatus.CREATED)
                .body(service.guardar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AcademicoDTO> actualizar(
            @PathVariable Long id,
            @RequestBody AcademicoRequestDTO dto) {

        return ResponseEntity.ok(
                service.actualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(
            @PathVariable Long id) {

        service.eliminar(id);

        return ResponseEntity.noContent()
                .build();
    }
}


