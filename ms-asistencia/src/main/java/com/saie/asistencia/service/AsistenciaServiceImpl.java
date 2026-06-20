package com.saie.asistencia.service;

import com.saie.asistencia.client.AcademicoClient;
import com.saie.asistencia.client.UsuarioClient;
import com.saie.asistencia.dto.AsistenciaRequestDTO;

import com.saie.asistencia.model.Asistencia;
import com.saie.asistencia.repository.AsistenciaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AsistenciaServiceImpl implements AsistenciaService {

    @Autowired
    private AsistenciaRepository repository;

    @Autowired
    private UsuarioClient usuarioClient;

    @Autowired
    private AcademicoClient academicoClient;

    @Override
    public List<AsistenciaRequestDTO.AsistenciaDTO> listar() {
        return repository.findAll()
                .stream()
                .map(this::toDTO)
                .toList();
    }

    @Override
    public AsistenciaRequestDTO.AsistenciaDTO guardar(AsistenciaRequestDTO dto) {

        usuarioClient.obtenerUsuario(dto.getAlumnoId());
        academicoClient.obtenerAcademico(dto.getCursoId());

        Asistencia a = new Asistencia();

        a.setAlumnoId(dto.getAlumnoId());
        a.setCursoId(dto.getCursoId());
        a.setEstado(dto.getEstado());
        a.setFecha(dto.getFecha());

        return toDTO(repository.save(a));
    }

    private AsistenciaRequestDTO.AsistenciaDTO toDTO(Asistencia a) {

        AsistenciaRequestDTO.AsistenciaDTO dto = new AsistenciaRequestDTO.AsistenciaDTO();

        dto.setId(a.getId());
        dto.setAlumnoId(a.getAlumnoId());
        dto.setCursoId(a.getCursoId());
        dto.setEstado(a.getEstado());
        dto.setFecha(a.getFecha());

        return dto;
    }
}

