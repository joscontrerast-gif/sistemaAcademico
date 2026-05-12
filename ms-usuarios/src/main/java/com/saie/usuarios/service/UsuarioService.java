package com.saie.usuarios.service;

import com.saie.usuarios.dto.UsuarioRequestDTO;
import com.saie.usuarios.dto.UsuarioResponseDTO;

import java.util.List;

public interface UsuarioService {

    UsuarioResponseDTO crearUsuario(UsuarioRequestDTO dto);

    List<UsuarioResponseDTO> listarUsuarios();

    UsuarioResponseDTO obtenerUsuario(Long id);

    UsuarioResponseDTO actualizarUsuario(Long id,
                                         UsuarioRequestDTO dto);

    void eliminarUsuario(Long id);
}