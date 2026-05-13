package com.saie.evaluacion.service;

import com.saie.evaluacion.dto.CalificacionDTO;
import com.saie.evaluacion.dto.CalificacionRequestDTO;
import com.saie.evaluacion.exception.ResourceNotFoundException;
import com.saie.evaluacion.model.Calificacion;
import com.saie.evaluacion.repository.CalificacionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalificacionServiceImpl
        implements CalificacionService {

    @Autowired
    private CalificacionRepository repository;

    @Override
    public List<CalificacionDTO> listar() {

        return repository.findAll()
                .stream()
                .map(this::convertirDTO)
                .toList();
    }

    @Override
    public CalificacionDTO obtener(Long id) {

        Calificacion calificacion =
                repository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Calificación no encontrada"));

        return convertirDTO(calificacion);
    }

    @Override
    public CalificacionDTO guardar(
            CalificacionRequestDTO dto) {

        Calificacion calificacion =
                new Calificacion();

        calificacion.setEvaluacionId(
                dto.getEvaluacionId());

        calificacion.setEstudianteId(
                dto.getEstudianteId());

        calificacion.setNota(
                dto.getNota());

        calificacion.setObservacion(
                dto.getObservacion());

        Calificacion guardada =
                repository.save(calificacion);

        return convertirDTO(guardada);
    }

    @Override
    public CalificacionDTO actualizar(
            Long id,
            CalificacionRequestDTO dto) {

        Calificacion calificacion =
                repository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Calificación no encontrada"));

        calificacion.setEvaluacionId(
                dto.getEvaluacionId());

        calificacion.setEstudianteId(
                dto.getEstudianteId());

        calificacion.setNota(
                dto.getNota());

        calificacion.setObservacion(
                dto.getObservacion());

        Calificacion actualizada =
                repository.save(calificacion);

        return convertirDTO(actualizada);
    }

    @Override
    public void eliminar(Long id) {

        Calificacion calificacion =
                repository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Calificación no encontrada"));

        repository.delete(calificacion);
    }

    private CalificacionDTO convertirDTO(
            Calificacion calificacion) {

        CalificacionDTO dto =
                new CalificacionDTO();

        dto.setId(
                calificacion.getId());

        dto.setEvaluacionId(
                calificacion.getEvaluacionId());

        dto.setEstudianteId(
                calificacion.getEstudianteId());

        dto.setNota(
                calificacion.getNota());

        dto.setObservacion(
                calificacion.getObservacion());

        return dto;
    }
}