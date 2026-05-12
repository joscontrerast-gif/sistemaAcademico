package com.saie.matricula.service;

import com.saie.matricula.dto.*;

import java.util.List;

public interface MatriculaService {

    List<MatriculaDTO> listar();

    MatriculaDTO obtener(Long id);

    MatriculaDTO guardar(
            MatriculaRequestDTO dto);

    MatriculaDTO actualizar(
            Long id,
            MatriculaRequestDTO dto);

    void eliminar(Long id);
}