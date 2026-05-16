package com.saie.academico.service;

import com.saie.academico.dto.AcademicoDTO;
import com.saie.academico.dto.AcademicoRequestDTO;

import com.saie.academico.dto.AcademicoResponseDTO;
import com.saie.academico.model.Academico;

import com.saie.academico.repository.AcademicoRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcademicoServiceImpl
        implements AcademicoService {

    @Autowired
    private AcademicoRepository repository;

    @Override
    public List<AcademicoDTO> listar() {

        return repository.findAll()
                .stream()
                .map(this::convertirDTO)
                .toList();
    }

    @Override
    public AcademicoDTO obtener(Long id) {

        Academico academico =
                repository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Académico no encontrado"));

        return convertirDTO(academico);
    }

    @Override
    public AcademicoDTO guardar(
            AcademicoRequestDTO dto) {

        Academico academico =
                new Academico();

        academico.setNombre(
                dto.getNombre());

        academico.setCarrera(
                dto.getCarrera());

        academico.setAsignatura(
                dto.getAsignatura());

        academico.setPromedio(
                dto.getPromedio());

        Academico guardado =
                repository.save(academico);

        return convertirDTO(guardado);
    }

    @Override
    public AcademicoDTO actualizar(
            Long id,
            AcademicoRequestDTO dto) {

        Academico academico =
                repository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Académico no encontrado"));

        academico.setNombre(
                dto.getNombre());

        academico.setCarrera(
                dto.getCarrera());

        academico.setAsignatura(
                dto.getAsignatura());

        academico.setPromedio(
                dto.getPromedio());

        Academico actualizado =
                repository.save(academico);

        return convertirDTO(actualizado);
    }

    @Override
    public void eliminar(Long id) {

        repository.deleteById(id);
    }

    @Override
    public AcademicoResponseDTO buscarPorId(Long id) {
        return null;
    }

    private AcademicoDTO convertirDTO(
            Academico academico) {

        AcademicoDTO dto =
                new AcademicoDTO();

        dto.setId(
                academico.getId());

        dto.setNombre(
                academico.getNombre());

        dto.setCarrera(
                academico.getCarrera());

        dto.setAsignatura(
                academico.getAsignatura());

        dto.setPromedio(
                academico.getPromedio());

        return dto;
    }
}