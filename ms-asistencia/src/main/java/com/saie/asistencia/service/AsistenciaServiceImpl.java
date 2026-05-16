package com.saie.asistencia.service;

import com.saie.asistencia.client.AcademicoClient;
import com.saie.asistencia.client.UsuarioClient;
import com.saie.asistencia.dto.AsistenciaRequestDTO;
import com.saie.asistencia.dto.AsistenciaResponseDTO;
import com.saie.asistencia.dto.external.AcademicoDTO;
import com.saie.asistencia.dto.external.UsuarioDTO;
import com.saie.asistencia.exception.ResourceNotFoundException;
import com.saie.asistencia.model.Asistencia;
import com.saie.asistencia.repository.AsistenciaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AsistenciaServiceImpl implements AsistenciaService {

    private final AsistenciaRepository repository;
    private final UsuarioClient usuarioClient;
    private final AcademicoClient academicoClient;

    @Override
    public List<AsistenciaResponseDTO> listar() {

        return repository.findAll()
                .stream()
                .map(this::convertirDTO)
                .toList();
    }

    @Override
    public AsistenciaResponseDTO buscarPorId(Long id) {

        Asistencia asistencia = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Registro no encontrado"));

        return convertirDTO(asistencia);
    }

    @Override
    public AsistenciaResponseDTO guardar(AsistenciaRequestDTO dto) {

        Asistencia asistencia = new Asistencia();

        asistencia.setUsuarioId(dto.getUsuarioId());
        asistencia.setAcademicoId(dto.getAcademicoId());
        asistencia.setEstudiante(dto.getEstudiante());
        asistencia.setAsignatura(dto.getAsignatura());
        asistencia.setFecha(dto.getFecha());
        asistencia.setPresente(dto.getPresente());

        return convertirDTO(repository.save(asistencia));
    }

    @Override
    public AsistenciaResponseDTO actualizar(Long id, AsistenciaRequestDTO dto) {

        Asistencia asistencia = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Registro no encontrado"));

        asistencia.setUsuarioId(dto.getUsuarioId());
        asistencia.setAcademicoId(dto.getAcademicoId());
        asistencia.setEstudiante(dto.getEstudiante());
        asistencia.setAsignatura(dto.getAsignatura());
        asistencia.setFecha(dto.getFecha());
        asistencia.setPresente(dto.getPresente());

        return convertirDTO(repository.save(asistencia));
    }

    @Override
    public void eliminar(Long id) {

        Asistencia asistencia = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Registro no encontrado"));

        repository.delete(asistencia);
    }

    private AsistenciaResponseDTO convertirDTO(Asistencia asistencia) {

        UsuarioDTO usuario =
                usuarioClient.obtenerUsuario(asistencia.getUsuarioId());

        AcademicoDTO academico =
                academicoClient.obtenerAcademico(asistencia.getAcademicoId());

        return new AsistenciaResponseDTO(
                asistencia.getId(),
                asistencia.getAcademicoId(),
                asistencia.getUsuarioId(),
                asistencia.getEstudiante(),
                asistencia.getAsignatura(),
                asistencia.getFecha(),
                asistencia.getPresente(),
                usuario,
                academico
        );
    }
}