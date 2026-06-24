package com.saie.matricula.client;

import com.saie.matricula.dto.AcademicoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "academicoClient"
)
public interface AcademicoClient {

    @GetMapping("/api/academicos/{id}")
    AcademicoDTO getAcademicoById(
            @PathVariable Long id);
}