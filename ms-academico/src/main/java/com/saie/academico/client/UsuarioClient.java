package com.saie.academico.client;

import com.saie.academico.dto.external.UsuarioDTO;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(
        name = "ms-usuarios",
        url = "http://localhost:8081")

public interface UsuarioClient {

    @GetMapping("/api/usuarios/{id}")
    UsuarioDTO obtenerUsuario(
            @PathVariable Long id);
}