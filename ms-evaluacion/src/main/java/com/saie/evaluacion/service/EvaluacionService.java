package com.saie.evaluacion.service;

import com.saie.evaluacion.dto.*;

import java.util.List;

public interface EvaluacionService {

    List<EvaluacionDTO> listar();

    EvaluacionDTO obtener(Long id);

    EvaluacionDTO guardar(
            EvaluacionRequestDTO dto);

    EvaluacionDTO actualizar(
            Long id,
            EvaluacionRequestDTO dto);

    void eliminar(Long id);
}