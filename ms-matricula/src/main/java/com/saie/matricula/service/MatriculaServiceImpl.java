package com.saie.matricula.service;

import com.saie.matricula.dto.MatriculaDTO;
import com.saie.matricula.dto.MatriculaRequestDTO;
import com.saie.matricula.exception.ResourceNotFoundException;
import com.saie.matricula.model.Matricula;
import com.saie.matricula.repository.MatriculaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MatriculaServiceImpl
        implements MatriculaService {

    @Autowired
    private MatriculaRepository repository;

    @Override
    public List<MatriculaDTO> listar() {

        return repository.findAll()
                .stream()
                .map(this::convertirDTO)
                .toList();
    }

    @Override
    public MatriculaDTO obtener(Long id) {

        Matricula matricula =
                repository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Matrícula no encontrada"));

        return convertirDTO(matricula);
    }

    @Override
    public MatriculaDTO guardar(
            MatriculaRequestDTO dto) {

        Matricula matricula =
                new Matricula();

        matricula.setEstudianteId(
                dto.getEstudianteId());

        matricula.setCursoId(
                dto.getCursoId());

        matricula.setEstado(
                dto.getEstado());

        matricula.setFechaMatricula(
                LocalDate.now());

        return convertirDTO(
                repository.save(matricula));
    }

    @Override
    public MatriculaDTO actualizar(
            Long id,
            MatriculaRequestDTO dto) {

        Matricula matricula =
                repository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Matrícula no encontrada"));

        matricula.setEstudianteId(
                dto.getEstudianteId());

        matricula.setCursoId(
                dto.getCursoId());

        matricula.setEstado(
                dto.getEstado());

        return convertirDTO(
                repository.save(matricula));
    }

    @Override
    public void eliminar(Long id) {

        Matricula matricula =
                repository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Matrícula no encontrada"));

        repository.delete(matricula);
    }

    private MatriculaDTO convertirDTO(
            Matricula matricula) {

        MatriculaDTO dto =
                new MatriculaDTO();

        dto.setId(matricula.getId());

        dto.setEstudianteId(
                matricula.getEstudianteId());

        dto.setCursoId(
                matricula.getCursoId());

        dto.setFechaMatricula(
                matricula.getFechaMatricula());

        dto.setEstado(
                matricula.getEstado());

        return dto;
    }
}