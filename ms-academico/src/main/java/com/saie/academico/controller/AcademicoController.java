package com.saie.academico.controller;

import com.saie.academico.dto.AcademicoRequestDTO;
import com.saie.academico.dto.AcademicoResponseDTO;
import com.saie.academico.service.AcademicoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/academicos")
@RequiredArgsConstructor
public class AcademicoController {

    private final AcademicoService service;

    @GetMapping
    public List<AcademicoResponseDTO> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public AcademicoResponseDTO buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AcademicoResponseDTO guardar(@RequestBody AcademicoRequestDTO dto) {
        return service.guardar(dto);
    }

    @PutMapping("/{id}")
    public AcademicoResponseDTO actualizar(@PathVariable Long id,
                                           @RequestBody AcademicoRequestDTO dto) {

        return service.actualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}