package com.saie.usuarios.service;

import com.saie.usuarios.dto.UsuarioRequestDTO;
import com.saie.usuarios.dto.UsuarioResponseDTO;
import com.saie.usuarios.model.Usuario;
import com.saie.usuarios.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface UsuarioService {

    Usuario guardar(Usuario usuario);

    UsuarioResponseDTO crearUsuario(UsuarioRequestDTO dto);

    List<UsuarioResponseDTO> listarUsuarios();

    UsuarioResponseDTO obtenerUsuario(Long id);

    UsuarioResponseDTO actualizarUsuario(Long id,
                                         UsuarioRequestDTO dto);

    void eliminarUsuario(Long id);
}