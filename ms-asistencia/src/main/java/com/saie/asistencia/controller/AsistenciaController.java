package com.saie.asistencia.controller;

import com.saie.asistencia.dto.AsistenciaRequestDTO;
import com.saie.asistencia.dto.AsistenciaResponseDTO;
import com.saie.asistencia.service.AsistenciaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/asistencias")
@RequiredArgsConstructor
public class AsistenciaController {

    private final AsistenciaService service;

    @GetMapping
    public List<AsistenciaResponseDTO> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public AsistenciaResponseDTO buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AsistenciaResponseDTO guardar(@RequestBody AsistenciaRequestDTO dto) {
        return service.guardar(dto);
    }

    @PutMapping("/{id}")
    public AsistenciaResponseDTO actualizar(@PathVariable Long id,
                                            @RequestBody AsistenciaRequestDTO dto) {

        return service.actualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}