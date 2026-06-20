package com.saie.usuarios.service;

import com.saie.usuarios.dto.UsuarioDTO;
import com.saie.usuarios.dto.UsuarioRequestDTO;
import com.saie.usuarios.model.Usuario;
import com.saie.usuarios.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Override
    public List<UsuarioDTO> listar() {
        return repository.findAll()
                .stream()
                .map(this::toDTO)
                .toList();
    }

    @Override
    public UsuarioDTO obtener(Long id) {

        Usuario usuario = repository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Usuario no encontrado"
                        ));
        return toDTO(usuario);
    }

    @Override
    public UsuarioDTO guardar(UsuarioRequestDTO dto) {

        Usuario usuario = new Usuario();

        usuario.setNombre(dto.getNombre());
        usuario.setCorreo(dto.getCorreo());

        Usuario saved = repository.save(usuario);

        return toDTO(saved);
    }

    @Override
    public UsuarioDTO actualizar(Long id, UsuarioRequestDTO dto) {

        Usuario usuario = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        usuario.setNombre(dto.getNombre());
        usuario.setCorreo(dto.getCorreo());

        return toDTO(repository.save(usuario));
    }

    @Override
    public void eliminarUsuario(Long id) {
        repository.deleteById(id);
    }

    private UsuarioDTO toDTO(Usuario usuario) {

        UsuarioDTO dto = new UsuarioDTO();

        dto.setId(usuario.getId());
        dto.setNombre(usuario.getNombre());
        dto.setCorreo(usuario.getCorreo());

        return dto;
    }
}