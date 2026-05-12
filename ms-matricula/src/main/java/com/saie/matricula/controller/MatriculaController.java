package com.saie.matricula.controller;

import com.saie.matricula.dto.*;
import com.saie.matricula.service.MatriculaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/matriculas")
public class MatriculaController {

    @Autowired
    private MatriculaService service;

    @GetMapping
    public List<MatriculaDTO> listar(){
        return service.listar();
    }

    @GetMapping("/{id}")
    public MatriculaDTO obtener(
            @PathVariable Long id){

        return service.obtener(id);
    }

    @PostMapping
    public MatriculaDTO guardar(
            @RequestBody
            MatriculaRequestDTO dto){

        return service.guardar(dto);
    }

    @PutMapping("/{id}")
    public MatriculaDTO actualizar(
            @PathVariable Long id,
            @RequestBody
            MatriculaRequestDTO dto){

        return service.actualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(
            @PathVariable Long id){

        service.eliminar(id);
    }
}