package com.saie.academico.service;

import com.saie.academico.dto.AcademicoRequestDTO;
import com.saie.academico.dto.AcademicoResponseDTO;

import java.util.List;

public interface AcademicoService {

    List<AcademicoResponseDTO> listar();

    AcademicoResponseDTO buscarPorId(Long id);

    AcademicoResponseDTO guardar(AcademicoRequestDTO dto);

    AcademicoResponseDTO actualizar(Long id, AcademicoRequestDTO dto);

    void eliminar(Long id);
}