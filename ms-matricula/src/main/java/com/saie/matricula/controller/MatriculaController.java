package com.saie.matricula.controller;

import com.saie.matricula.dto.MatriculaDTO;
import com.saie.matricula.dto.MatriculaRequestDTO;
import com.saie.matricula.service.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/matriculas")
public class MatriculaController {

    @Autowired
    private MatriculaService service;

    //LISTAR TODAS LAS MATRÍCULAS
    @GetMapping
    public ResponseEntity<List<MatriculaDTO>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    //OBTENER MATRÍCULA POR ID
    @GetMapping("/{id}")
    public ResponseEntity<MatriculaDTO> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(service.obtener(id));
    }

    // CREAR MATRÍCULA (INSCRIBIR ESTUDIANTE EN CURSO)
    @PostMapping
    public ResponseEntity<MatriculaDTO> guardar(
            @RequestBody MatriculaRequestDTO dto) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.guardar(dto));
    }

    //ACTUALIZAR MATRÍCULA
    @PutMapping("/{id}")
    public ResponseEntity<MatriculaDTO> actualizar(
            @PathVariable Long id,
            @RequestBody MatriculaRequestDTO dto) {

        return ResponseEntity.ok(service.actualizar(id, dto));
    }

    //ELIMINAR MATRÍCULA
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    // CONSULTA POR ESTUDIANTE (MUY IMPORTANTE EN TU SISTEMA)
    @GetMapping("/estudiante/{id}")
    public ResponseEntity<List<MatriculaDTO>> porEstudiante(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorEstudiante(id));
    }

    // CONSULTA POR CURSO
    @GetMapping("/curso/{id}")
    public ResponseEntity<List<MatriculaDTO>> porCurso(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorCurso(id));
    }
}