package com.saie.usuarios.controller;

import com.saie.usuarios.dto.UsuarioRequestDTO;
import com.saie.usuarios.dto.UsuarioResponseDTO;
import com.saie.usuarios.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService service;
    //
    @PostMapping
    public ResponseEntity<UsuarioResponseDTO>
    crearUsuario(@RequestBody UsuarioRequestDTO dto) {

        return ResponseEntity.ok(
                service.crearUsuario(dto));
    }
    //ENDPOINT
    @GetMapping
    public ResponseEntity<List<UsuarioResponseDTO>>
    listarUsuarios() {

        return ResponseEntity.ok(
                service.listarUsuarios());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO>
    obtenerUsuario(@PathVariable Long id) {

        return ResponseEntity.ok(
                service.obtenerUsuario(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO>
    actualizarUsuario(
            @PathVariable Long id,
            @RequestBody UsuarioRequestDTO dto) {

        return ResponseEntity.ok(
                service.actualizarUsuario(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>
    eliminarUsuario(@PathVariable Long id) {

        service.eliminarUsuario(id);

        return ResponseEntity.noContent().build();
    }
}