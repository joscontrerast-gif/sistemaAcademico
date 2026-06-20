package com.saie.usuarios.controller;

import com.saie.usuarios.dto.UsuarioDTO;
import com.saie.usuarios.dto.UsuarioRequestDTO;

import com.saie.usuarios.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(service.obtener(id));
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> guardar(
            @RequestBody UsuarioRequestDTO dto) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.guardar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTO> actualizar(
            @PathVariable Long id,
            @RequestBody UsuarioRequestDTO dto) {

        return ResponseEntity.ok(service.actualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminarUsuario(id);
        return ResponseEntity.noContent().build();
    }
}