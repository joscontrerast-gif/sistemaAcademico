package com.saie.matricula.client;

import com.saie.matricula.dto.external.UsuarioDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "usuarioClient",
        url = "http://localhost:8081"
)
public interface UsuarioClient {

    @GetMapping("/api/usuarios/{id}")
    UsuarioDTO getUsuarioById(
            @PathVariable Long id);
}