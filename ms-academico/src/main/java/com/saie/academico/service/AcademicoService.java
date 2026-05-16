package com.saie.academico.service;

import com.saie.academico.dto.AcademicoDTO;
import com.saie.academico.dto.AcademicoRequestDTO;
import com.saie.academico.dto.AcademicoResponseDTO;

import java.util.List;

public interface AcademicoService {

    List<AcademicoDTO> listar();

    AcademicoDTO obtener(Long id);

    AcademicoDTO guardar(
            AcademicoRequestDTO dto);

    AcademicoDTO actualizar(
            Long id,
            AcademicoRequestDTO dto);

    void eliminar(Long id);

    AcademicoResponseDTO buscarPorId(Long id);
}