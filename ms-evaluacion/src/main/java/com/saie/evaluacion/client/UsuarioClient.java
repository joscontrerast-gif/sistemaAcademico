package com.saie.evaluacion.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-usuarios", url = "http://localhost:8081")
public interface UsuarioClient {

    @GetMapping("/api/usuarios/{id}")
    String obtenerUsuario(@PathVariable Long id);
}