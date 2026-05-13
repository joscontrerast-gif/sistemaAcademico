package com.saie.evaluacion.service;

import com.saie.evaluacion.dto.EvaluacionDTO;
import com.saie.evaluacion.dto.EvaluacionRequestDTO;
import com.saie.evaluacion.exception.ResourceNotFoundException;
import com.saie.evaluacion.model.Evaluacion;
import com.saie.evaluacion.repository.EvaluacionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvaluacionServiceImpl
        implements EvaluacionService {

    @Autowired
    private EvaluacionRepository repository;

    @Override
    public List<EvaluacionDTO> listar() {

        return repository.findAll()
                .stream()
                .map(this::convertirDTO)
                .toList();
    }

    @Override
    public EvaluacionDTO obtener(Long id) {

        Evaluacion evaluacion =
                repository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Evaluación no encontrada"));

        return convertirDTO(evaluacion);
    }

    @Override
    public EvaluacionDTO guardar(
            EvaluacionRequestDTO dto) {

        Evaluacion evaluacion =
                new Evaluacion();

        evaluacion.setNombre(
                dto.getNombre());

        evaluacion.setCursoId(
                dto.getCursoId());

        evaluacion.setFecha(
                dto.getFecha());

        evaluacion.setPonderacion(
                dto.getPonderacion());

        Evaluacion guardada =
                repository.save(evaluacion);

        return convertirDTO(guardada);
    }

    @Override
    public EvaluacionDTO actualizar(
            Long id,
            EvaluacionRequestDTO dto) {

        Evaluacion evaluacion =
                repository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Evaluación no encontrada"));

        evaluacion.setNombre(
                dto.getNombre());

        evaluacion.setCursoId(
                dto.getCursoId());

        evaluacion.setFecha(
                dto.getFecha());

        evaluacion.setPonderacion(
                dto.getPonderacion());

        Evaluacion actualizada =
                repository.save(evaluacion);

        return convertirDTO(actualizada);
    }

    @Override
    public void eliminar(Long id) {

        Evaluacion evaluacion =
                repository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Evaluación no encontrada"));

        repository.delete(evaluacion);
    }

    private EvaluacionDTO convertirDTO(
            Evaluacion evaluacion) {

        EvaluacionDTO dto =
                new EvaluacionDTO();

        dto.setId(
                evaluacion.getId());

        dto.setNombre(
                evaluacion.getNombre());

        dto.setCursoId(
                evaluacion.getCursoId());

        dto.setFecha(
                evaluacion.getFecha());

        dto.setPonderacion(
                evaluacion.getPonderacion());

        return dto;
    }
}