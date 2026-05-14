package com.saie.asistencia.service;

import com.saie.asistencia.dto.AsistenciaRequestDTO;
import com.saie.asistencia.dto.AsistenciaResponseDTO;

import java.util.List;

public interface AsistenciaService {

    List<AsistenciaResponseDTO> listar();

    AsistenciaResponseDTO buscarPorId(Long id);

    AsistenciaResponseDTO guardar(AsistenciaRequestDTO dto);

    AsistenciaResponseDTO actualizar(Long id, AsistenciaRequestDTO dto);

    void eliminar(Long id);
}