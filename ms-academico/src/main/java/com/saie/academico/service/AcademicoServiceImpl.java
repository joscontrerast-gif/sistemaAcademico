package com.saie.academico.service;

import com.saie.academico.client.UsuarioClient;
import com.saie.academico.dto.AcademicoRequestDTO;
import com.saie.academico.dto.AcademicoResponseDTO;
import com.saie.academico.exception.ResourceNotFoundException;
import com.saie.academico.model.Academico;
import com.saie.academico.repository.AcademicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AcademicoServiceImpl implements AcademicoService {

    private final AcademicoRepository repository;
    @Autowired
    private UsuarioClient usuarioClient;

    @Override
    public List<AcademicoResponseDTO> listar() {

        return repository.findAll()
                .stream()
                .map(this::convertirDTO)
                .toList();
    }

    @Override
    public AcademicoResponseDTO buscarPorId(Long id) {

        Academico academico = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Registro no encontrado"));

        return convertirDTO(academico);
    }

    @Override
    public AcademicoResponseDTO guardar(AcademicoRequestDTO dto) {

        Academico academico = new Academico();

        academico.setNombre(dto.getNombre());
        academico.setCarrera(dto.getCarrera());
        academico.setAsignatura(dto.getAsignatura());
        academico.setPromedio(dto.getPromedio());

        return convertirDTO(repository.save(academico));
    }

    @Override
    public AcademicoResponseDTO actualizar(Long id, AcademicoRequestDTO dto) {

        Academico academico = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Registro no encontrado"));

        academico.setNombre(dto.getNombre());
        academico.setCarrera(dto.getCarrera());
        academico.setAsignatura(dto.getAsignatura());
        academico.setPromedio(dto.getPromedio());

        return convertirDTO(repository.save(academico));
    }

    @Override
    public void eliminar(Long id) {

        Academico academico = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Registro no encontrado"));

        repository.delete(academico);
    }

    private AcademicoResponseDTO convertirDTO(Academico academico) {

        return new AcademicoResponseDTO(
                academico.getId(),
                academico.getNombre(),
                academico.getCarrera(),
                academico.getAsignatura(),
                academico.getPromedio()
        );
    }
}