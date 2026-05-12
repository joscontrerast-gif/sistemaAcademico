package com.saie.usuarios.service;

import com.saie.usuarios.dto.UsuarioRequestDTO;
import com.saie.usuarios.dto.UsuarioResponseDTO;
import com.saie.usuarios.exception.ResourceNotFoundException;
import com.saie.usuarios.model.Usuario;
import com.saie.usuarios.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository repository;
    //CREAR USUARIO
    @Override
    public UsuarioResponseDTO crearUsuario(UsuarioRequestDTO dto) {

        Usuario usuario = new Usuario();

        usuario.setNombre(dto.getNombre());
        usuario.setCorreo(dto.getCorreo());
        usuario.setRol(dto.getRol());

        Usuario guardado = repository.save(usuario);

        return new UsuarioResponseDTO(
                guardado.getId(),
                guardado.getNombre(),
                guardado.getCorreo()
        );
    }
    //LISTAR USUARIOS
    @Override
    public List<UsuarioResponseDTO> listarUsuarios() {

        return repository.findAll()
                .stream()
                .map(usuario -> new UsuarioResponseDTO(
                        usuario.getId(),
                        usuario.getNombre(),
                        usuario.getCorreo()
                ))
                .toList();
    }
    //OBTENER USUSARIOS POR ID
    @Override
    public UsuarioResponseDTO obtenerUsuario(Long id) {

        Usuario usuario = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Usuario no encontrado"));

        return new UsuarioResponseDTO(
                usuario.getId(),
                usuario.getNombre(),
                usuario.getCorreo()
        );
    }
    //ACTUALIZAR USUSARIO
    @Override
    public UsuarioResponseDTO actualizarUsuario(
            Long id,
            UsuarioRequestDTO dto) {

        Usuario usuario = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Usuario no encontrado"));
        usuario.setNombre(dto.getNombre());
        usuario.setCorreo(dto.getCorreo());
        usuario.setRol(dto.getRol());

        Usuario actualizado = repository.save(usuario);

        return new UsuarioResponseDTO(
                actualizado.getId(),
                actualizado.getNombre(),
                actualizado.getCorreo()
        );
    }
    //ELIMINAR USUARIOS
    @Override
    public void eliminarUsuario(Long id) {

        Usuario usuario = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Usuario no encontrado"));

        repository.delete(usuario);
    }

}