package com.saie.usuarios.controller;
import com.saie.usuarios.dto.UsuarioRequestDTO;
import com.saie.usuarios.dto.UsuarioResponseDTO;
import com.saie.usuarios.model.Usuario;
import com.saie.usuarios.security.JwtService;
import com.saie.usuarios.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;


import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    //TEMPORAL, BORRAR
    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> crearUsuario(
            @RequestBody UsuarioRequestDTO dto) {

        System.out.println("ENTRO AL NUEVO METODO");

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(usuarioService.crearUsuario(dto));
    }
    //TEMPORAL BORRAR

    //USUARIO DEVUELVE MAS QUE EL ID
    //@PostMapping
    //public ResponseEntity<UsuarioResponseDTO> crearUsuario(@RequestBody UsuarioRequestDTO dto){
    //    return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.crearUsuario(dto));
    //}

    @GetMapping
    public ResponseEntity<List<UsuarioResponseDTO>>
    listarUsuarios() {

        return ResponseEntity.ok(
                usuarioService.listarUsuarios());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO>
    obtenerUsuario(@PathVariable Long id) {

        return ResponseEntity.ok(
                usuarioService.obtenerUsuario(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO>
    actualizarUsuario(
            @PathVariable Long id,
            @RequestBody UsuarioRequestDTO dto) {

        return ResponseEntity.ok(
                usuarioService.actualizarUsuario(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>
    eliminarUsuario(@PathVariable Long id) {

        usuarioService.eliminarUsuario(id);

        return ResponseEntity.noContent().build();
    }
}