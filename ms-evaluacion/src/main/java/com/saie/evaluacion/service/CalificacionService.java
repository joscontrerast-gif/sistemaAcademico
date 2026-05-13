package com.saie.evaluacion.service;

import com.saie.evaluacion.dto.*;

import java.util.List;

public interface CalificacionService {

    List<CalificacionDTO> listar();

    CalificacionDTO obtener(Long id);

    CalificacionDTO guardar(
            CalificacionRequestDTO dto);

    CalificacionDTO actualizar(
            Long id,
            CalificacionRequestDTO dto);

    void eliminar(Long id);
}