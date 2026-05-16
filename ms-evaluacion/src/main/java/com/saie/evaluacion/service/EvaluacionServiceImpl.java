package com.saie.evaluacion.service;

import com.saie.evaluacion.client.AcademicoClient;
import com.saie.evaluacion.client.UsuarioClient;

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

    @Autowired
    private UsuarioClient usuarioClient;

    @Autowired
    private AcademicoClient academicoClient;

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

        // VALIDAR PROFESOR
        usuarioClient.obtenerUsuario(
                dto.getProfesorId());

        // VALIDAR ACADÉMICO
        academicoClient.obtenerAcademico(
                dto.getCursoId());

        Evaluacion evaluacion =
                new Evaluacion();

        evaluacion.setNombre(
                dto.getNombre());

        evaluacion.setProfesorId(
                dto.getProfesorId());

        evaluacion.setCursoId(
                dto.getCursoId());

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

        // VALIDAR PROFESOR
        usuarioClient.obtenerUsuario(
                dto.getProfesorId());

        // VALIDAR ACADÉMICO
        academicoClient.obtenerAcademico(
                dto.getCursoId());

        evaluacion.setNombre(
                dto.getNombre());

        evaluacion.setProfesorId(
                dto.getProfesorId());

        evaluacion.setCursoId(
                dto.getCursoId());

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
                evaluacion.getProfesorId());

        dto.setCursoId(
                evaluacion.getCursoId());

        dto.setPonderacion(
                evaluacion.getPonderacion());

        return dto;
    }
}