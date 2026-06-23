package com.saie.matricula.controller;

import com.saie.matricula.dto.MatriculaDTO;
import com.saie.matricula.dto.MatriculaRequestDTO;
import com.saie.matricula.service.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.hateoas.EntityModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.util.List;


    @Tag(name = "Matrículas", description = "Gestión de matrículas estudiantiles")
    @RestController
    @RequestMapping("/api/matriculas")
    public class MatriculaController {

    @Autowired
    private MatriculaService service;

    //LISTAR TODAS LAS MATRÍCULAS
    @Operation(summary = "Listar todas las matrículas")
    @GetMapping
    public ResponseEntity<List<MatriculaDTO>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    //OBTENER MATRÍCULA POR ID
    @Operation(summary = "Obtener matrícula por ID")
    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<MatriculaDTO>> obtener(
            @PathVariable Long id) {

        MatriculaDTO matricula = service.obtener(id);

        EntityModel<MatriculaDTO> model =
                EntityModel.of(matricula);

        model.add(
                linkTo(
                        methodOn(MatriculaController.class)
                                .obtener(id) )
                        .withSelfRel() ); return ResponseEntity.ok(model);
    }
    // CREAR MATRÍCULA (INSCRIBIR ESTUDIANTE EN CURSO)
    @Operation(summary = "Crear matrícula")
    @PostMapping
    public ResponseEntity<MatriculaDTO> guardar(
            @RequestBody MatriculaRequestDTO dto) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.guardar(dto));
    }

    //ACTUALIZAR MATRÍCULA
    @Operation(summary = "Actualizar matrícula")
    @PutMapping("/{id}")
    public ResponseEntity<MatriculaDTO> actualizar(
            @PathVariable Long id,
            @RequestBody MatriculaRequestDTO dto) {

        return ResponseEntity.ok(service.actualizar(id, dto));
    }

    //ELIMINAR MATRÍCULA
    @Operation(summary = "Eliminar matrícula")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    // CONSULTA POR ESTUDIANTE (MUY IMPORTANTE EN TU SISTEMA)
    @GetMapping("/estudiante/{id}")
    @Operation(summary = "Buscar matrículas por estudiante")
    public ResponseEntity<List<MatriculaDTO>> porEstudiante(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorEstudiante(id));
    }

    // CONSULTA POR CURSO
    @GetMapping("/curso/{id}")
    @Operation(summary = "Buscar matrículas por curso")
    public ResponseEntity<List<MatriculaDTO>> porCurso(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorCurso(id));
    }
}