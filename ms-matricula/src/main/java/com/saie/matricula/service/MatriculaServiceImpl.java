package com.saie.matricula.service;

import com.saie.matricula.dto.MatriculaDTO;
import com.saie.matricula.dto.MatriculaRequestDTO;
import com.saie.matricula.model.Matricula;
import com.saie.matricula.repository.MatriculaRepository;
import com.saie.matricula.client.UsuarioClient;
import com.saie.matricula.client.AcademicoClient;

import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MatriculaServiceImpl implements MatriculaService {

    @Autowired
    private MatriculaRepository repository;

    @Autowired
    private UsuarioClient usuarioClient; // ms-usuarios

    @Autowired
    private AcademicoClient academicoClient; // ms-academico

    //LISTAR TODAS
    @Override
    public List<MatriculaDTO> listar() {
        return repository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    // OBTENER POR ID
    @Override
    public MatriculaDTO obtener(Long id) {
        Matricula m = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Matrícula no encontrada"));

        return toDTO(m);
    }

    //CREAR MATRÍCULA


    @Override
    public MatriculaDTO guardar(MatriculaRequestDTO dto) {

        try {
            usuarioClient.getUsuarioById(dto.getEstudianteId());
        } catch (FeignException e) {
            throw new RuntimeException("Usuario no existe con id: " + dto.getEstudianteId());
        }

        try {
            academicoClient.getAcademicoById(dto.getCursoId());
        } catch (FeignException e) {
            throw new RuntimeException("Académico no existe con id: " + dto.getCursoId());
        }

        Matricula m = new Matricula();
        m.setEstudianteId(dto.getEstudianteId());
        m.setCursoId(dto.getCursoId());
        m.setFechaMatricula(LocalDate.now());
        m.setEstado("ACTIVA");

        return toDTO(repository.save(m));
    }
    // ACTUALIZAR
    @Override
    public MatriculaDTO actualizar(Long id, MatriculaRequestDTO dto) {

        Matricula m = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Matrícula no encontrada"));

        // validar existencia
        usuarioClient.getUsuarioById(dto.getEstudianteId());
        academicoClient.getAcademicoById(dto.getCursoId());

        m.setEstudianteId(dto.getEstudianteId());
        m.setCursoId(dto.getCursoId());
        m.setEstado(dto.getEstado());

        return toDTO(repository.save(m));
    }

    //ELIMINAR
    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }

    // FILTRAR POR ESTUDIANTE
    @Override
    public List<MatriculaDTO> buscarPorEstudiante(Long id) {
        return repository.findByEstudianteId(id)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    //FILTRAR POR CURSO
    @Override
    public List<MatriculaDTO> buscarPorCurso(Long id) {
        return repository.findByCursoId(id)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    // MAPPER
    private MatriculaDTO toDTO(Matricula m) {
        MatriculaDTO dto = new MatriculaDTO();
        dto.setId(m.getId());
        dto.setEstudianteId(m.getEstudianteId());
        dto.setCursoId(m.getCursoId());
        dto.setFechaMatricula(m.getFechaMatricula());
        dto.setEstado(m.getEstado());
        return dto;
    }
}