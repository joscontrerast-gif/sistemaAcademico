package com.saie.asistencia.service;

import com.saie.asistencia.dto.AsistenciaRequestDTO;


import java.util.List;

public interface AsistenciaService {

    List<AsistenciaRequestDTO.AsistenciaDTO> listar();

    AsistenciaRequestDTO.AsistenciaDTO guardar(AsistenciaRequestDTO dto);
}